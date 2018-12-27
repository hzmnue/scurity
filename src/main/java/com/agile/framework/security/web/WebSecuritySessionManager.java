package com.agile.framework.security.web;

import com.agile.framework.security.session.Session;
import com.agile.framework.security.session.impl.manager.DefaultSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

public class WebSecuritySessionManager extends DefaultSessionManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Session doCreateSession(Object... params) {
        if(params==null||params.length==0||!(params[0] instanceof HttpSession)){
            logger.error("error params:"+params);
            throw new IllegalArgumentException("error params:"+params);
        }
        return new WebSecuritySession((HttpSession)params[0]);
    }
}
