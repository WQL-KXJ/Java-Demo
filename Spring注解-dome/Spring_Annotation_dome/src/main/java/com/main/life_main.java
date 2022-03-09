package com.main;

import com.config.config_annotation;
import com.config.life_annotation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class life_main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(life_annotation.class);

        System.out.println("容器创建完成！");
        applicationContext.getBean("postconstruct_test");

        applicationContext.close();
    }
}
