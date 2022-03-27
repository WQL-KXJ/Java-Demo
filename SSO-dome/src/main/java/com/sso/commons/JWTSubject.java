package com.sso.commons;

//做为Subject数据使用，也就是PyeLoad数据中的Claims
public class JWTSubject {

    private String username;

    public JWTSubject() {
        super();
    }
    public JWTSubject(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
