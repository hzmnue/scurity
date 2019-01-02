package com.agile.framework.security;

import java.util.List;

public  class SubjectManager {


    public static Subject getSubject(String sessionId) {
        Session session=  SessionManager.getSession(sessionId);
        return session==null?null:new Subject(session);
    }

    //如果有过期时间,按过期时间判断是否删除subject
    //如果没有,按subject管理里设置的多久没活动便注销subject

    public static void flushSubject() {
        SessionManager.flushSession();
    }

    public static void invalidSubject(String subjectId) {
        SessionManager.invalidSession(subjectId);
    }

    public static Subject  createSubject() {
        Session session=  SessionManager.createSession();
        return new Subject(session);
    }

    public static void setVerifyServices(List<VerifyService> verifyServices){
        Subject.setVerifyServices(verifyServices);
   }

    public static void setSessionDao(SessionDao sessionDao){
        SessionManager.setSessionDao(sessionDao);
    }
}



