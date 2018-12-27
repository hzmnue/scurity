package com.agile.framework.security.session;


public interface SessionManager {

    public Session getSession(String  sessionId);

    public Session invalidSession(String sessionId);

    public String createSessionId();

    public Session createSession(String sessionId);
}
