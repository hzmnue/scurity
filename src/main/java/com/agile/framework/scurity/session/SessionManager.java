package com.agile.framework.scurity.session;


public interface SessionManager<T> {

    public T createSessionId();

    public Session createSession(T  sessionId);

    public Session getSession(T  sessionId);

    public Session invalidSession(T  sessionId);

}
