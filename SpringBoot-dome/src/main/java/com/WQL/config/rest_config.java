package com.WQL.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration(proxyBeanMethods = false)
public class rest_config {

    @Bean
    public HiddenHttpMethodFilter hidd(){

        HiddenHttpMethodFilter httpMethodFilter =new HiddenHttpMethodFilter();
        //通过它的set方法把参数修改返回即可
        httpMethodFilter.setMethodParam("_wql");
        return httpMethodFilter;
    }
}
