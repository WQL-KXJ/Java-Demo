package com.sso.commons;

import java.util.HashMap;
import java.util.Map;

//模拟数据库用户
public class JWTUsers {
    //使用map模拟数据库
    private static final Map<String,String> USERS = new HashMap<String, String>();

    //初始化USERS增加10个用户
    static {
        for(int i=1;i<=10;i++){
            USERS.put("UserAdmin"+i,"PassWord"+i);
        }}

    public static boolean isLogin(String username,String password){

        //用户为空
        if(username.length()<=0){
            return false;
        }
        String passwords = USERS.get(username);

        //判断密码是否正确
        if(passwords!=null){
            if (passwords.equals(password)){
            return true;
            }
        }

        return false;
    }


}
