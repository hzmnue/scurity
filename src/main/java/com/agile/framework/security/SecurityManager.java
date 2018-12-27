package com.agile.framework.security;

import com.agile.framework.security.common.Constants;
import com.agile.framework.security.session.Session;
import com.agile.framework.security.session.SessionManager;
import com.agile.framework.security.session.impl.manager.DefaultSessionManager;


public class SecurityManager {

    private VerifyService verifyService;
    private SessionManager sessionManager;
    private static SecurityManager instance;

    public static SecurityManager getInstance(){
        if(instance==null){
            instance=new SecurityManager();
            instance.setSessionManager(new DefaultSessionManager());
        }
        return instance;
    }

    public Session createSession(){
        String sessionId=sessionManager.createSessionId();
        return sessionManager.createSession(sessionId);
    }

    public void login(String sessionId,Object token){
        Session session= sessionManager.getSession(sessionId);
        verifyService.doVerify(token);
        session.setAttribute("token"+ Constants.SUFFIX,token);
    }

    public void logOff(String sessionId){
        sessionManager.invalidSession(sessionId);
    }

    public boolean doAuthorize(String sessionId){
        Session session= sessionManager.getSession(sessionId);
        return verifyService.doAuthorize(session);
    }

    public Session getSesssion(String sessionId){
        return sessionManager.getSession(sessionId);
    }

    public void setVerifyService(VerifyService verifyService) {
        this.verifyService = verifyService;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
