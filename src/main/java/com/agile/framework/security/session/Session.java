package com.agile.framework.security.session;

public interface Session {

    public <V> void setAttribute(String key, V o);

    public <R> R getAttribute(String key);

    public void removeAttribute(String key);

    public String getId();



}
