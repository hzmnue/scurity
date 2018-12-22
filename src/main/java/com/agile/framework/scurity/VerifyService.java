package com.agile.framework.scurity;

import com.agile.framework.scurity.session.Session;

public interface VerifyService {

    public boolean doAuthorize(Session session);

    public void doVerify(Object token);
}
