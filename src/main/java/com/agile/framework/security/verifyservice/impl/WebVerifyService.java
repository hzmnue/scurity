package com.agile.framework.security.verifyservice.impl;

import com.agile.framework.security.token.SecurityToken;
import com.agile.framework.security.token.WebSecurityToken;
import com.agile.framework.security.verifyservice.VerifyService;
import com.agile.framework.security.web.WebSubjectUtils;

public class WebVerifyService implements VerifyService {

    @Override
    public boolean doAuthorize(SecurityToken token) {
        WebSecurityToken webSecurityToken=(WebSecurityToken)token;
        return webSecurityToken.containsUri(WebSubjectUtils.getRequest().getRequestURI());
    }

    @Override
    public boolean doVerify(SecurityToken token) {

        return true;
    }
}
