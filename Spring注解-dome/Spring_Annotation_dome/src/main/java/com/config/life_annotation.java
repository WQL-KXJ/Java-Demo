package com.config;

import com.bean.init_dostroy_test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(value = "com.bean")
@PropertySource("classpath:/config.properties")//加载外部配置文件
@Configuration
public class life_annotation {

//    @Bean(value = "get_init_destroy",initMethod = "init",destroyMethod = "destroy")
//    public init_dostroy_test get_init_destroy(){
//
//        return new init_dostroy_test("initMethod和destroyMethod进行初始化和销毁！");
//    }
}
