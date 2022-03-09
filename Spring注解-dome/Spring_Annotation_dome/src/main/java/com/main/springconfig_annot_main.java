package com.main;

import com.config.c3p0_config;
import com.config.config_annotation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class springconfig_annot_main {
    public static void main(String[] args) {

        //1,通过注解配置类方式获取上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //2,设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("dev");

        //3,注册主配置类
        applicationContext.register(c3p0_config.class);

        //4,启动刷新容器
        applicationContext.refresh();


        //获取所有的bean
        String[] names = applicationContext.getBeanDefinitionNames();

        //打印所有的名称
        for(String name:names){

            System.out.println(name);
        }

    }
}
