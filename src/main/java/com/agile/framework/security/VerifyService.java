package com.agile.framework.security;

public interface VerifyService {

    public boolean doAuthorize(Object token);

    public boolean doVerify(Object token);
}
