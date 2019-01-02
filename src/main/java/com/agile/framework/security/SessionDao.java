package com.agile.framework.security;

public interface SessionDao {
    public Session getSession(String sessionId);

    public void invalidSession(String sessionId);

    public Session createSession();

    public void  flushSession();


}
