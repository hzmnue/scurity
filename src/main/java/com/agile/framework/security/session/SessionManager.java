package com.agile.framework.security.session;


public interface SessionManager {

    public Session getSession(String  sessionId);

    public Session invalidSession(String sessionId);

    public Session createSessionId();

    public Session createSession(String sessionId);
}
