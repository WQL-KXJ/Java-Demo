package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MySelfRlue {

    @Bean
    public IRule Myrule(){
        return new RandomRule(); //定义随机
    }
}
