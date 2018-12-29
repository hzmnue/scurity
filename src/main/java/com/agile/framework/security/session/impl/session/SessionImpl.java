package com.agile.framework.security.session.impl.session;

import com.agile.framework.security.session.Session;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionImpl implements Session {

    private String sessionId;
    private Map<String,Object> attributes=new ConcurrentHashMap<>();

    public SessionImpl(String sessionId) {
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
