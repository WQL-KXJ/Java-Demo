package com.kxjsecurity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Author WQL-KXJ
 * @ProjectName Springboot-SpringSecurity-Dome
 * @PackageName com.kxjsecurity
 * @Date 2022/8/14 16:04
 * @Version 1.0
 */
@RestController
public class logincontroller {

    @RequestMapping(value = "/login-success", produces = "text/plain;charset=UTF-8")
    public String success() {
        String username =getUsername();
        return username+"登录成功";
    }


    @RequestMapping(value = "/login-failure", produces = "text/plain;charset=UTF-8")
    public String failure() {
        String username =getUsername();
        return username+"登录失败";
    }

    @RequestMapping(value = "/wql/a1", produces = "text/plain;charset=UTF-8")
    public String wqla1() {
        String username =getUsername();
        return username+"登录成功";
    }

    //获取用户名
    private String getUsername() {

        //用户名
        String username = null;

        //通过SecurityContextHolder获取认证通过的用户信息Authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //通过Authentication的用户身份信息
        Object principal = authentication.getPrincipal();

        if (principal == null) {
            username = "匿名用户";
        }

        //判断principal是否是UserDetails的子类
        if (principal instanceof UserDetails) {
            //强转
            UserDetails userDetails = (UserDetails) principal;
            //获取username
            username = userDetails.getUsername();
        }
        return username;
    }
}