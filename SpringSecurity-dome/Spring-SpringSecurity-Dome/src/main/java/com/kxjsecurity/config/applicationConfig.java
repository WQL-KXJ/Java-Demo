package com.kxjsecurity.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/*
 * @Author WQL-KXJ
 * @ProjectName Spring-SpringSecurity-Dome
 * @PackageName com.kxjsecurity.config
 * @Date 2022/8/12 22:32
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.kxjsecurity",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})

public class applicationConfig {
    //在此配置除了Controller的其他bean，比如：数据库连接池、事物管理器、业务bean等

}
