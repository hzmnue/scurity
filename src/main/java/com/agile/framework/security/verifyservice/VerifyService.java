package com.agile.framework.security.verifyservice;

import com.agile.framework.security.token.SecurityToken;

public interface VerifyService {

    public boolean doAuthorize(SecurityToken token);

    public boolean doVerify(SecurityToken token);
}
