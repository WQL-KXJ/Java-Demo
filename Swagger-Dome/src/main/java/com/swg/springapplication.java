package com.swg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * @Author WQL-KXJ
 * @ProjectName Swagger-Dome
 * @PackageName com.swg
 * @Date 2022/7/29 23:12
 * @Version 1.0
 */
@SpringBootApplication
@EnableSwagger2 //EnableSwagger2是springfox提供的一个注解，代表swagger2相关技术开启。它会扫描当前类所在包及其子包中所有类型注解
public class springapplication {

    public static void main(String[] args) {
        SpringApplication.run(springapplication.class,args);
    }

}
