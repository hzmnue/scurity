package com.agile.framework.scurity.session;

import java.util.HashMap;
import java.util.Map;

public class DefaultSessionManager implements SessionManager<String> {

    Map<String,Session> sessionMap=new HashMap<>();

    @Override
    public String createSessionId() {
        return Math.random()*2000+"";
    }

    @Override
    public Session createSession(String sessionId) {
        Session session=new DefaultSession(sessionId);
        sessionMap.put(sessionId,session);
        return session;
    }

    @Override
    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    @Override
    public Session invalidSession(String sessionId) {
        return sessionMap.remove(sessionId);
    }
}
