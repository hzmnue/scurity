package com.agile.framework.security.session.impl.manager;

import com.agile.framework.security.common.Constants;
import com.agile.framework.security.session.AbstractSessionManager;
import com.agile.framework.security.session.Session;
import com.agile.framework.security.session.SessionManagerFilter;
import com.agile.framework.security.session.impl.session.SessionImpl;
import com.agile.framework.security.utils.MD5Util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultSessionManager extends AbstractSessionManager {

    private static String LAST_ACTIVE_TIME_KEY = "agiel_session_last_active_time";
    private static String EXIPRE_TIME_KEY = "agiel_session_create_active_time";
    private AtomicInteger idSeed=new AtomicInteger(0);
    private long expireTime=1000*60*20;
    private Map<String,Session> sessionMap=new ConcurrentHashMap<>();



    @Override
    public Session doCreateSession() {
        String sessionId= createSessionId();
        Session session=new SessionImpl(sessionId);
        sessionMap.put(sessionId,session);
        return session;
    }

    @Override
    public Session doReadSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    @Override
    public void doInvalidSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    @Override
    public void doFlushSession() {
        for (Session session : sessionMap.values()) {
            Object sessionExpireTime=session.getAttribute(EXIPRE_TIME_KEY);
            if(sessionExpireTime==null){
                long lastActiveTime= (long)session.getAttribute(LAST_ACTIVE_TIME_KEY);
                if(lastActiveTime-System.currentTimeMillis()>expireTime){
                    sessionMap.remove(session.getId());
                }
            }else if(System.currentTimeMillis()>(Long)sessionExpireTime){
                sessionMap.remove(session.getId());
            }
        }
    }



    public String createSessionId() {
        String sessionId= System.currentTimeMillis()+ Constants.SUFFIX+idSeed;
        sessionId= MD5Util.encode(sessionId);
        return sessionId;
    }


    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }
}
