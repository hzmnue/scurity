package com.agile.framework.security.session;


public interface SessionFilter {

    public void setAttribute(Session session,String s, Object o);

    public Object getAttribute(Session session,String s);

    public void removeAttribute(Session session,String s);

    public String getId(Session session);

}
