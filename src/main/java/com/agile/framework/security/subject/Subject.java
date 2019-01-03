package com.agile.framework.security.subject;

import com.agile.framework.security.verifyservice.VerifyService;
import com.agile.framework.security.session.Session;
import com.agile.framework.security.token.SecurityToken;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private static String AGILE_SECURITY_TOKEN="agile_security_token";
    private Session session;
    private static List<VerifyService> verifyServices=new ArrayList<>();


    public Subject(Session session) {
        this.session = session;
    }

    public boolean login(SecurityToken token){
        for(VerifyService verifyService:verifyServices){
            if(!verifyService.doVerify(token))
                return false;
        }
        token.setLogin(true);
        session.setAttribute(AGILE_SECURITY_TOKEN,token);
        return true;
    }


    public void logOff() {
        session.setAttribute(AGILE_SECURITY_TOKEN,null);
    }

    public boolean doAuthorize() {
        SecurityToken token= session.getAttribute(AGILE_SECURITY_TOKEN);
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

    static void addVerifyServices(VerifyService verifyService) {
        Subject.verifyServices.add(verifyService);
    }
}
