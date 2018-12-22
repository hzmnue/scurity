package com.agile.framework.scurity.session;

public interface Session {

    public void setAttribute(String s, Object o);

    public Object getAttribute(String s);

    public void removeAttribute(String s);

    public void setAuth(String s, Object o);

    public Object getAuth(String s);

    public void removeAuth(String s);

    public Object getSessionId();

}
