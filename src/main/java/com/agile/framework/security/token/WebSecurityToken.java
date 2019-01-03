package com.agile.framework.security.token;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WebSecurityToken extends SecurityToken {

    private Set<String> uris=new HashSet<>();

    public WebSecurityToken(String username, String password) {
        super(username, password);
    }

    public void addUri(String uri){
        uris.add(uri);
    }

    public Set<String> getAllUri(){
        return uris;
    }

    public boolean containsUri(String uri){
        return uris.contains(uri);
    }
}
