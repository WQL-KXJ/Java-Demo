package com.WQL;

import com.WQL.config.servlet_my;
import com.WQL.config.servletfilter_my;
import com.WQL.config.servletlistener_my;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication标记为主程序类
@SpringBootApplication
@MapperScan
@ServletComponentScan(basePackageClasses = {servlet_my.class, servletfilter_my.class, servletlistener_my.class})
public class springbootapplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(springbootapplication.class, args);

//        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//
//        for (String a:beanDefinitionNames){
//
//            System.out.println(a);
//        }

    }
}
