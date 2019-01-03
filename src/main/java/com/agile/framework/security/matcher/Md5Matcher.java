package com.agile.framework.security.matcher;

import com.agile.framework.security.token.SecurityToken;
import com.agile.framework.security.utils.MD5Util;

public class Md5Matcher implements TokenMatcher {
    private int count;
    private String salt="";

    public Md5Matcher(int count) {
        this.count = count;
    }

    public Md5Matcher(String salt) {
        this.salt = salt;
    }

    public Md5Matcher(int count, String salt) {
        this.count = count;
        this.salt = salt;
    }

    @Override
    public boolean matcher(SecurityToken token) {
        String result= this.encode(token);
        return result.equals(token.getCertificate());
    }

    @Override
    public String encode(SecurityToken token) {
        String username= token.getUsername();
        String password= token.getPassword();

        String result=username+salt+password;
        for(int i=0;i<count;i++){
            result+=salt;
            result= MD5Util.encode(result);
        }
        return result;
    }
}
