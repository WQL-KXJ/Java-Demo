package com.kxjsecurity.springmvc.service;

import com.kxjsecurity.springmvc.pojo.UserDetails;
import com.kxjsecurity.springmvc.pojo.authenticationRequest;

/*
 * @Author WQL-KXJ
 * @ProjectName Session-dome
 * @PackageName com.kxjsecurity.springmvc.service
 * @Date 2022/8/11 22:49
 * @Version 1.0
 */
public interface AuthenticationService {

    UserDetails authentication(authenticationRequest auth);

}
