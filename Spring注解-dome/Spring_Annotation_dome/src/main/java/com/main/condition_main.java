package com.main;

import com.config.config_annotation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class condition_main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(config_annotation.class);

        Object test = applicationContext.getBean("get_windown");
       // Object test1 = applicationContext.getBean("get_linux");

        System.out.println(test);
        //System.out.println(test1);
    }
}
