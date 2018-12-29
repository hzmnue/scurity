package com.agile.framework.security.session;


public interface SessionManager {

    public Session getSession(String sessionId);

    public void flushSession();

    public void invalidSession(String sessionId);

    public Session createSession();

    public void setSessionFilter(SessionFilter sessionFilter);

    public void setSessionManagerFilter(SessionManagerFilter sessionManagerFilter);
}
