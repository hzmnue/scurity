package com.agile.framework.scurity.session.impl.manager;

import com.agile.framework.scurity.common.Constants;
import com.agile.framework.scurity.session.Session;
import com.agile.framework.scurity.session.SessionManager;
import com.agile.framework.scurity.session.impl.session.DefaultSession;
import com.agile.framework.scurity.utils.MD5Util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultSessionManager implements SessionManager {

    private Map<String,Session> sessionMap=new ConcurrentHashMap<>();
    private AtomicInteger idSeed=new AtomicInteger(0);

    @Override
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    @Override
    public Session invalidSession(String sessionId) {
            return sessionMap.remove(sessionId);
    }

    @Override
    public final Session createSession(Object... params) {
        Session session=doCreateSession(params);
        sessionMap.put(session.getId(),session);
        return session;
    }

    public  Session doCreateSession(Object... params) {
        String sessionId= MD5Util.encode(idSeed.getAndIncrement()+Constants.SUFFIX);
        Session session= new DefaultSession(sessionId);
        return session;
    }
}
