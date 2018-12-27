package com.agile.framework.security.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import com.agile.framework.security.SecurityManager;
public class WebSecurityRequest extends HttpServletRequestWrapper {

    public WebSecurityRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public HttpSession getSession() {
        HttpSession session= super.getSession();
        if(session.isNew()) return (HttpSession) SecurityManager.getInstance().createSession(session);
        return (HttpSession) SecurityManager.getInstance().getSesssion(session.getId());
    }

    @Override
    public HttpSession getSession(boolean create) {
        return (HttpSession) SecurityManager.getInstance().createSession(super.getSession(create));
    }
}
