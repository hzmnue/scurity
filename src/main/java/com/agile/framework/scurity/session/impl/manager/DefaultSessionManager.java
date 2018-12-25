package com.agile.framework.scurity.session.impl.manager;

import com.agile.framework.scurity.session.Session;
import com.agile.framework.scurity.session.SessionManager;
import com.agile.framework.scurity.session.impl.session.DefaultSession;

import java.util.HashMap;
import java.util.Map;

public class DefaultSessionManager implements SessionManager<Object> {

    Map<Object,Session> sessionMap=new HashMap<>();

    @Override
    public Object createSessionId() {
        return Math.random()*2000+"";
    }

    @Override
    public Session createSession(Object sessionId) {
        Session session=new DefaultSession(sessionId);
        sessionMap.put(session.getSessionId(),session);
        return session;
    }

    @Override
    public Session getSession(Object sessionId) {
        return sessionMap.get(sessionId);
    }

    @Override
    public Session invalidSession(Object sessionId) {
        return sessionMap.remove(sessionId);
    }
}
