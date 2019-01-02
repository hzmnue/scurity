package com.agile.framework.security;

import java.util.List;

public class Subject {
    private static String AGILE_SECURITY_TOKEN="agile_security_token";
    private Session session;
    private static List<VerifyService> verifyServices;


    public Subject(Session session) {
        this.session = session;
    }

    public boolean login(Object token){
        for(VerifyService verifyService:verifyServices){
            if(!verifyService.doVerify(token))
                return false;
        }
        session.setAttribute(AGILE_SECURITY_TOKEN,token);
        return true;
    }


    public void logOff() {
        session.setAttribute(AGILE_SECURITY_TOKEN,null);
    }

    public boolean doAuthorize() {
        Object token= session.getAttribute(AGILE_SECURITY_TOKEN);
        for(VerifyService verifyService:verifyServices){
            if(!verifyService.doAuthorize(token))
                return false;
        }
        return true;
    }

    public Session getSesssion() {
        return session;
    }

    public boolean isExipred() {
        return false;
    }

    public boolean setExipredTime(long time) {
        return false;
    }

    static void setVerifyServices(List<VerifyService> verifyServices) {
        Subject.verifyServices = verifyServices;
    }
}
