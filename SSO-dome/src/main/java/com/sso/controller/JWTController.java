package com.sso.controller;

import com.sso.commons.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class JWTController {

    @RequestMapping("/test")
    @ResponseBody
    public Object test(HttpServletRequest request){
        //获取请求头中携带的Token
        String Token = request.getHeader("Authorization");
        //效验Token
        JWTResult result = JWTUtils.validataJWT(Token);

        JWTResponseData responseData = new JWTResponseData();

        //效验成功
        if(result.isSuccess()){
            responseData.setCode(200);
            responseData.setData(result.getClaims().getSubject());
            //更新Token，超时时间为1分钟
            String jwt = JWTUtils.CreateJWT(result.getClaims().getId(), "WQL_SSO", result.getClaims().getSubject(), 1 * 60 * 1000);
            responseData.setToken(jwt);
            responseData.setMsg("效验成功！");
            return responseData;
        }else {
            responseData.setCode(500);
            responseData.setMsg("用户未登录！");
            return request;
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object login(String username,String password){
        JWTResponseData responseData;
        System.out.print(username+"\n"+password);
        if(JWTUsers.isLogin(username,password)){
            //Subject转化
            JWTSubject jwtSubject = new JWTSubject(username);
            //创建一个Token
            String jwtToken = JWTUtils.CreateJWT(UUID.randomUUID().toString(), "WQL_SSO", JWTUtils.generalSubject(jwtSubject), 1 * 60 * 1000);
            responseData = new JWTResponseData();
            responseData.setCode(200);
            responseData.setData(null);
            responseData.setMsg("登录成功");
            responseData.setToken(jwtToken);
        }else {
            responseData = new JWTResponseData();
            responseData.setCode(500);
            responseData.setData(null);
            responseData.setMsg("登录失败");
            responseData.setToken(null);
        }

        return responseData;
    }


}
