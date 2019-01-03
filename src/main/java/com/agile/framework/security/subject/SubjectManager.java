package com.agile.framework.security.subject;

import com.agile.framework.security.session.impl.DefaultSessionDao;
import com.agile.framework.security.verifyservice.VerifyService;
import com.agile.framework.security.session.Session;
import com.agile.framework.security.session.SessionDao;


import java.util.List;

public class SubjectManager {

    private SessionDao sessionDao;


    public SubjectManager() {
        this.sessionDao = new DefaultSessionDao();
    }


    public Subject getSubject(String sessionId) {
        Session session=  sessionDao.getSession(sessionId);
        return session==null?null:new Subject(session);
    }

    //如果有过期时间,按过期时间判断是否删除subject
    //如果没有,按subject管理里设置的多久没活动便注销subject

    public  void flushSubject() {
        sessionDao.flushSession();
    }

    public  void invalidSubject(String subjectId) {
        sessionDao.invalidSession(subjectId);
    }

    public  Subject  createSubject() {
        Session session=  sessionDao.createSession();
        return new Subject(session);
    }

    public  void addVerifyServices(VerifyService verifyService){
        Subject.addVerifyServices(verifyService);
   }

    public void setSessionDao(SessionDao sessionDao) {
        this.sessionDao = sessionDao;
    }
}



