package com.agile.framework.scurity;

import com.agile.framework.scurity.session.DefaultSessionManager;
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

    public Session login(Object token){
         verifyService.doVerify(token);
         Object sessionId= sessionManager.createSessionId();
         Session session= sessionManager.createSession(sessionId);
         return session;
    }

    public void logOff(Session session){
        sessionManager.invalidSession(session);
    }

    public boolean doAuthorize(Session session){
      return verifyService.doAuthorize(session);
    }

    public Session getSession(Object sessionId) {
        return this.sessionManager.getSession(sessionId);
    }
}
