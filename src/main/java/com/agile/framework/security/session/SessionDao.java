package com.agile.framework.security.session;

import com.agile.framework.security.session.Session;

public interface SessionDao {
    public Session getSession(String sessionId);

    public void invalidSession(String sessionId);

    public Session createSession();

    public void  flushSession();


}
