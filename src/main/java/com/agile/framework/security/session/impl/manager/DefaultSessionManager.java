package com.agile.framework.security.session.impl.manager;

import com.agile.framework.security.common.Constants;
import com.agile.framework.security.session.Session;
import com.agile.framework.security.session.SessionManager;
import com.agile.framework.security.session.impl.session.DefaultSession;
import com.agile.framework.security.utils.MD5Util;

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
    public String createSessionId() {
        String sessionId= System.currentTimeMillis()+Constants.SUFFIX+idSeed;
        sessionId= MD5Util.encode(sessionId);
        return sessionId;
    }

    @Override
    public Session createSession(String sessionId) {
        Session session=new DefaultSession(sessionId);
        sessionMap.put(sessionId,session);
        return session;
    }



}
