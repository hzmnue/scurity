package com.agile.framework.security;

import com.agile.framework.security.common.Constants;
import com.agile.framework.security.session.Session;
import com.agile.framework.security.session.SessionManager;
import com.agile.framework.security.session.impl.manager.DefaultSessionManager;

import java.util.ArrayList;
import java.util.List;


public class SecurityManager {

    private List<VerifyService> verifyServices=new ArrayList<>();
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

    public boolean login(String sessionId,Object token){
        Session session= sessionManager.getSession(sessionId);
        for(VerifyService verifyService:verifyServices){
            if(!verifyService.doVerify(token))
                return false;
        }
        session.setAttribute("token"+ Constants.SUFFIX,token);
        return true;
    }

    public void logOff(String sessionId){
        sessionManager.invalidSession(sessionId);
    }

    public boolean doAuthorize(String sessionId){
        Session session= sessionManager.getSession(sessionId);
        Object token= session.getAttribute("token"+ Constants.SUFFIX);
        for(VerifyService verifyService:verifyServices){
            if(!verifyService.doVerify(token))
                return false;
        }
        return true;
    }

    public Session getSesssion(String sessionId){
        return sessionManager.getSession(sessionId);
    }

    public void addVerifyService(VerifyService verifyService) {
        verifyServices.add(verifyService);
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
