package com.config;

import com.bean.bean_test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class resource_config {

    @Bean("get_bean_test")
    public bean_test get_bean_test(){

        return new bean_test("EDG",1);
    }

}
