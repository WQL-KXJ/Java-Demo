package com.main;

import com.config.config_annotation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class scope_main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(config_annotation.class);

        Object test = applicationContext.getBean("get_bean");
        Object test1 = applicationContext.getBean("get_bean");

        System.out.println(test==test1);
    }
}
