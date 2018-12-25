package com.agile.framework.scurity;

import com.agile.framework.scurity.common.Constants;
import com.agile.framework.scurity.session.impl.manager.DefaultSessionManager;
import com.agile.framework.scurity.session.Session;
import com.agile.framework.scurity.session.SessionManager;

public class ScurityManager {

    private VerifyService verifyService;
    private SessionManager sessionManager;


    public ScurityManager(VerifyService verifyService) {
        this(verifyService,new DefaultSessionManager());
    }

    public ScurityManager(VerifyService verifyService, SessionManager sessionManager) {
        this.verifyService = verifyService;
        this.sessionManager = sessionManager;
    }

    public Session createSession(Object... params){
        return sessionManager.createSession(params);
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

}
