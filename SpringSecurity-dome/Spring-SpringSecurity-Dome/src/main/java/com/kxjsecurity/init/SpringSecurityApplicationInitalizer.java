package com.kxjsecurity.init;

import com.kxjsecurity.config.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/*
 * @Author WQL-KXJ
 * @ProjectName Spring-SpringSecurity-Dome
 * @PackageName com.kxjsecurity.init
 * @Date 2022/8/12 23:53
 * @Version 1.0
 */
public class SpringSecurityApplicationInitalizer extends AbstractSecurityWebApplicationInitializer {

    public SpringSecurityApplicationInitalizer(){
    //super(WebSecurityConfig.class);
    }
}
