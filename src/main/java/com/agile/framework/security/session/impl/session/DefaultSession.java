package com.agile.framework.security.session.impl.session;

import com.agile.framework.security.session.Session;

import java.util.HashMap;
import java.util.Map;

public class DefaultSession implements Session {

    Map<String,Object> attributes=new HashMap<>();

    private String sessionId;

    public DefaultSession(String sessionId) {
        this.sessionId=sessionId;
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
        return this.sessionId;
    }
}
