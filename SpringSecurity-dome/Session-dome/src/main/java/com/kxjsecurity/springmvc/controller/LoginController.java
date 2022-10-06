package com.kxjsecurity.springmvc.controller;

import com.kxjsecurity.springmvc.pojo.UserDetails;
import com.kxjsecurity.springmvc.pojo.authenticationRequest;
import com.kxjsecurity.springmvc.service.AuthenticationServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/*
 * @Author WQL-KXJ
 * @ProjectName Session-dome
 * @PackageName com.kxjsecurity.springmvc.controller
 * @Date 2022/8/12 10:26
 * @Version 1.0
 */
@RestController
public class LoginController {

    @Autowired
    AuthenticationServiceimpl authenticationService;

    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String login(authenticationRequest a, HttpSession session){

        UserDetails authentication = authenticationService.authentication(a);

        //存入session
        session.setAttribute(UserDetails.SESSION_USER_KEY,authentication);

        return authentication.getUsername()+"登录成功！";
    }

    //测试是否有状态信息
    @RequestMapping(value = "/wql/status",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public String status(HttpSession session){

        Object attribute = session.getAttribute(UserDetails.SESSION_USER_KEY);

        if(ObjectUtils.isEmpty(attribute)){
            return "匿名访问！";
        }

        UserDetails Details=(UserDetails)attribute;

        return Details.getUsername()+"访问资源一！";
    }

    //测试资源2
    @RequestMapping(value = "/wql/resource",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public String resource(HttpSession session){

        Object attribute = session.getAttribute(UserDetails.SESSION_USER_KEY);

        if(ObjectUtils.isEmpty(attribute)){
            return "匿名访问！";
        }

        UserDetails Details=(UserDetails)attribute;

        return Details.getUsername()+"访问资源2！";
    }

    //退出
    @RequestMapping(value = "/logout",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public String logout(HttpSession session){
        //删除session
        session.removeAttribute(UserDetails.SESSION_USER_KEY);

        return "退出成功！";
    }

}
