package com.main;

import com.config.config_annotation;
import com.config.life_annotation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class value_main {

    public static void main(String[] args) {

        //通过注解配置类方式获取上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(life_annotation.class);

        //获取bean对象
        Object bean = applicationContext.getBean("value_test");

        System.out.println(bean);

    }
}
