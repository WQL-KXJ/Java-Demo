package com.sso.commons;

import io.jsonwebtoken.Claims;

//结果对象
public class JWTResult {

    //状态码
    private int Code;

    //是否成功
    private boolean success;

    //验证过程的PyeLoad数据
    private Claims claims;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Claims getClaims() {
        return claims;
    }

    public void setClaims(Claims claims) {
        this.claims = claims;
    }
}
