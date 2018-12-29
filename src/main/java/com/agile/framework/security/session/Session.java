package com.agile.framework.security.session;

public interface Session {

    public void setAttribute(String s, Object o);

    public Object getAttribute(String s);

    public void removeAttribute(String s);

    public String getId();



}
