package com.agile.framework.security.session;

import com.agile.framework.security.session.Session;
import com.agile.framework.security.session.SessionFilter;


class DefaultSessionProxy implements Session{

    static SessionFilter sessionFilter;
    private Session session;

    DefaultSessionProxy(Session session) {

        this.session = session;
    }

    @Override
    public void setAttribute(String s, Object o) {
        sessionFilter.setAttribute(session,s,o);
    }

    @Override
    public Object getAttribute(String s) {
        return   sessionFilter.getAttribute(session,s);
    }

    @Override
    public void removeAttribute(String s) {
        sessionFilter.removeAttribute(session,s);
    }

    @Override
    public String getId() {
        return sessionFilter.getId(session);
    }


}
