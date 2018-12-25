package com.agile.framework.scurity.session.impl.manager;

import com.agile.framework.scurity.session.Session;
import com.agile.framework.scurity.session.SessionManager;

import java.util.HashMap;
import java.util.Map;

public class WebSessionManager implements SessionManager {

    Map<Object,Session> sessionMap=new HashMap<>();
    @Override
    public Object createSessionId() {
        return null;
    }

    @Override
    public Session createSession(Object sessionId) {
        return null;
    }

    @Override
    public Session getSession(Object sessionId) {
        return null;
    }

    @Override
    public Session invalidSession(Object sessionId) {
        return null;
    }

}
