package com.main;

import com.config.config_annotation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class lazy_main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(config_annotation.class);

        Object getLazyBean = context.getBean("get_lazy_bean");

        System.out.println(getLazyBean);
    }
}
