package com.agile.framework.security.subject.impl.subject;

import com.agile.framework.security.VerifyService;
import com.agile.framework.security.session.Session;
import com.agile.framework.security.subject.Subject;

import java.util.List;

public class DefaultSubject implements Subject {
    private static String AGILE_SECURITY_TOKEN="agile_security_token";
    private Session session;
    private List<VerifyService> verifyServices;


    public DefaultSubject(Session session, List<VerifyService> verifyServices) {
        this.session = session;
        this.verifyServices = verifyServices;
    }

    @Override
    public boolean login(Object token){
        for(VerifyService verifyService:verifyServices){
            if(!verifyService.doVerify(token))
                return false;
        }
        session.setAttribute(AGILE_SECURITY_TOKEN,token);
        return true;
    }

    @Override
    public void logOff() {
        session.removeAttribute(AGILE_SECURITY_TOKEN);
    }

    @Override
    public boolean doAuthorize() {
        Object token= session.getAttribute(AGILE_SECURITY_TOKEN);
        for(VerifyService verifyService:verifyServices){
            if(!verifyService.doVerify(token))
                return false;
        }
        return true;
    }

    @Override
    public Session getSesssion() {
        return session;
    }

    @Override
    public boolean isExipred() {
        return false;
    }

    @Override
    public boolean setExipredTime(long time) {
        return false;
    }

    @Override
    public boolean getTokenId(long time) {
        return false;
    }

}
