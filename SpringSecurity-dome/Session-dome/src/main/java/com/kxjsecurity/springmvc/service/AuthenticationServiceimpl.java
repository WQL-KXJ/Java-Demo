package com.kxjsecurity.springmvc.service;

import com.kxjsecurity.springmvc.pojo.UserDetails;
import com.kxjsecurity.springmvc.pojo.authenticationRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * @Author WQL-KXJ
 * @ProjectName Session-dome
 * @PackageName com.kxjsecurity.springmvc.service
 * @Date 2022/8/11 23:10
 * @Version 1.0
 */
@Service
public class AuthenticationServiceimpl implements  AuthenticationService {

    private HashMap<String,UserDetails> map = new HashMap<>();

    {
        Set<String> a1 = new HashSet<>();
        a1.add("a1");
        Set<String> a2 = new HashSet<>();
        a2.add("a2");

        map.put("lishi",new UserDetails("1","lishi","123456",a1));
        map.put("wangwu",new UserDetails("2","wangwu","123456",a2));
    }

    @Override
    public UserDetails authentication(authenticationRequest auth) {

         if(ObjectUtils.isEmpty(auth) || StringUtils.isEmpty(auth.getUsername()) || StringUtils.isEmpty(auth.getPassword())){

             throw new RuntimeException("账号或者密码为空！");
         }

        UserDetails user = getUser(auth.getUsername());

         if(!user.getPassword().equals(auth.getPassword())){

             throw new RuntimeException("密码错误！");
         }

        return user;
    }

    //模拟查询
    private UserDetails getUser(String username){

        UserDetails userDetails = map.get(username);

        if(ObjectUtils.isEmpty(userDetails)){
            throw new RuntimeException("用户不存在！");
        }

        return userDetails;
    }



}
