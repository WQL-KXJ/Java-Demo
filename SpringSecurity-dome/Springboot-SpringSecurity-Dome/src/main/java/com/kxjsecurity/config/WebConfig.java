package com.kxjsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * @Author WQL-KXJ
 * @ProjectName Springboot-SpringSecurity-Dome
 * @PackageName com.kxjsecurity.config
 * @Date 2022/8/13 17:04
 * @Version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //默认URL根据跳转到/login，此url为spring security提供
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //输入项目地址自动重定向到登录页面
        registry.addViewController("/").setViewName("redirect:/loginview");
        //URL绑定登录页面
        registry.addViewController("/loginview").setViewName("/login");    }
}
