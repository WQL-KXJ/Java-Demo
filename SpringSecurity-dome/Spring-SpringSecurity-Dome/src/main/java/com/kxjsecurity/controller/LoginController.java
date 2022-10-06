package com.kxjsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Author WQL-KXJ
 * @ProjectName Spring-SpringSecurity-Dome
 * @PackageName com.kxjsecurity.controller
 * @Date 2022/8/12 23:56
 * @Version 1.0
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login-success",produces = "text/plain;charset=UTF-8")
    public String success(){
        return "登录成功";
    }

    @RequestMapping(value = "/wql/t1",produces = "text/plain;charset=UTF-8")
    public String t1(){
        return "访问t1资源成功！";
    }
    @RequestMapping(value = "/wql/t2",produces = "text/plain;charset=UTF-8")
    public String t2(){
        return "访问t2资源成功！";
    }
}
