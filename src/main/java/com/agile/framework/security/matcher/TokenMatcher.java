package com.agile.framework.security.matcher;

import com.agile.framework.security.token.SecurityToken;

public interface TokenMatcher  {
    public boolean matcher(SecurityToken token);

    public String encode(SecurityToken token);
}
