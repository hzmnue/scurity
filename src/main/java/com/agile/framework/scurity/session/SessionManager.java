package com.agile.framework.scurity.session;


public interface SessionManager {

    public Session getSession(String  sessionId);

    public Session invalidSession(String sessionId);

    public Session createSession(Object... params);
}
