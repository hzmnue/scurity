package com.agile.framework.scurity.session;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

public class DefaultSession implements Session {

    Map<String,Object> attributes=new HashMap<>();

    private Object sessionId;

    public DefaultSession(Object sessionId) {
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
    public void setAuth(String s, Object o) {
        attributes.put(s,o);
    }

    @Override
    public Object getAuth(String s) {
        return attributes.get(s);
    }

    @Override
    public void removeAuth(String s) {
        attributes.remove(s);
    }

    @Override
    public Object getSessionId() {
        return this.sessionId;
    }
}
