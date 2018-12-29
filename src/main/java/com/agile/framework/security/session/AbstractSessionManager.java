package com.agile.framework.security.session;

import com.agile.framework.security.session.impl.session.SessionImpl;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


//实现Session的过滤抽象类

public abstract class AbstractSessionManager implements SessionManager {

    private SessionManagerFilter sessionManagerFilter;





    @Override
    public Session getSession(String sessionId) {
        Session session= doReadSession(sessionId);
        if(sessionManagerFilter!=null)
            session=sessionManagerFilter.getSession(session);
        session=  new DefaultSessionProxy(session);
        return session;
    }

    //如果有过期时间,按过期时间判断是否删除session
    //如果没有,按session管理里设置的多久没活动便注销session
    @Override
    public void flushSession() {

       if(sessionManagerFilter!=null)
           sessionManagerFilter.flushSession();
        doFlushSession();

    }

    @Override
    public void invalidSession(String sessionId) {
         if(sessionManagerFilter!=null&&!sessionManagerFilter.invalidSession(doReadSession(sessionId))){
             return;
         }
         doInvalidSession(sessionId);
         return;
    }

    @Override
    public Session createSession() {
        Session session= doCreateSession();
        if(sessionManagerFilter!=null)
            session=sessionManagerFilter.createSession(session);
        session=  new DefaultSessionProxy(session);
        return session;
    }

    @Override
    public void setSessionFilter(SessionFilter sessionFilter) {
        DefaultSessionProxy.sessionFilter = sessionFilter;
    }

    @Override
    public void setSessionManagerFilter(SessionManagerFilter sessionManagerFilter) {
        this.sessionManagerFilter = sessionManagerFilter;
    }

    public abstract Session doCreateSession();

    public abstract Session doReadSession(String sessionId);

    public abstract void doInvalidSession(String sessionId);

    public abstract void doFlushSession();
}
