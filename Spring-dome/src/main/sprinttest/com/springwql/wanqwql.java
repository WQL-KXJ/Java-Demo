package com.springwql;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
* IOC的完全注解开发：不需要配置文件，直接注解
*
*
*
* */
@Configuration  //声明配置类取代xml配置文件
@ComponentScan( basePackages = "com.springwql") //设置组件扫描
public class wanqwql {

}
