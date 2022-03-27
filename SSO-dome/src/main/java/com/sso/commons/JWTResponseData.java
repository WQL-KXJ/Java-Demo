package com.sso.commons;

//发送给客户端的对象
public class JWTResponseData {

    private  Integer Code;//状态码

    private Object data;//业务数据

    private String msg;//返回描述

    private String token;//身份标识

    public Integer getCode() {
        return Code;
    }

    public void setCode(Integer code) {
        Code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
