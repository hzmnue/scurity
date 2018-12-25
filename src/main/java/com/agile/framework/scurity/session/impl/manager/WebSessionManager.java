package com.agile.framework.scurity.session.impl.manager;

import com.agile.framework.scurity.session.Session;
import com.agile.framework.scurity.session.SessionManager;
import com.agile.framework.scurity.session.impl.session.WebSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

public class WebSessionManager extends DefaultSessionManager{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Session doCreateSession(Object... params) {
        if(params==null||params.length==0||!(params[0] instanceof HttpSession)){
            logger.error("error params:"+params);
            throw new IllegalArgumentException("error params:"+params);
        }
        return new WebSession((HttpSession)params[0]);
    }
}
