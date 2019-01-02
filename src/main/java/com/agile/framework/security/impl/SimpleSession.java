package com.agile.framework.security.impl;

import com.agile.framework.security.Session;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleSession implements Session {

    private String id;
    private Map<String,Object> attributes=new ConcurrentHashMap<>();


    public SimpleSession() {

    }

    public SimpleSession(String sessionId) {
        this.id=sessionId;
    }

    @Override
    public void setAttribute(String s, Object o) {
        attributes.put(s,o);

    }

    @Override
    public Object getAttribute(String s) {
        return attributes.get(s);
    }

    @Override
    public void removeAttribute(String s) {
        attributes.remove(s);
    }

    @Override
    public String getId() {
        return this.id;
    }


}
