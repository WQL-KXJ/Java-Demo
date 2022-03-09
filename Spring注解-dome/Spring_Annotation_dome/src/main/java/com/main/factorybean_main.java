package com.main;

import com.config.config_annotation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class factorybean_main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(config_annotation.class);

        Object factoryBean = context.getBean("get_factory_bean");
        Object factoryBean1 = context.getBean("&get_factory_bean");

        System.out.println("FactoryBean生成的对象："+factoryBean);
        System.out.println("FactoryBean对象本身："+factoryBean1);

    }

}
