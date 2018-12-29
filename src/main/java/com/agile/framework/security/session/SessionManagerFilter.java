package com.agile.framework.security.session;

import java.util.Map;

public interface SessionManagerFilter {
    public Session getSession(Session  session);

    public boolean invalidSession(Session session);

    public Session createSession(Session session);

    public void  flushSession();
}
