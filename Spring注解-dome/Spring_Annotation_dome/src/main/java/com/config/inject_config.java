package com.config;

import com.bean.bean_test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class inject_config {

    @Bean
    public bean_test get_bean4(){
        return new bean_test("DK",2);
    }
}
