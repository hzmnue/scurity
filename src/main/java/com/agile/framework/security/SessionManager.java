package com.agile.framework.security;

import com.agile.framework.security.impl.DefaultSessionDao;

class SessionManager{

    private static SessionDao sessionDao=new DefaultSessionDao();

    public static Session getSession(String sessionId) {
        return sessionDao.getSession(sessionId);
    }

    public static void flushSession() {
        sessionDao.flushSession();
    }


    public static void invalidSession(String sessionId) {
        sessionDao.invalidSession(sessionId);
    }


    public static Session createSession() {
       return sessionDao.createSession();
    }


    public static void setSessionDao(SessionDao sessionDao) {
        SessionManager.sessionDao = sessionDao;
    }

}

