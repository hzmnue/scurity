package com.agile.framework.security.token;

public class SecurityToken {

    private String username;
    private String password;
    private String certificate;
    private boolean isLogin;

    public SecurityToken(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }


    public String getCertificate() {
        return certificate;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
