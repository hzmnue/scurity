package com.agile.framework.security.subject;

import com.agile.framework.security.session.Session;

public interface Subject {

    public boolean login(Object token);

    public void logOff();

    public boolean doAuthorize();

    public Session getSesssion();

    public boolean isExipred();

    public boolean setExipredTime(long time);

    public boolean getTokenId(long time);
}
