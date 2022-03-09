package com.config;

import com.bean.bean_test;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource
public class autowried_config {

    //加载两相同类型的Bean
    @Bean
    public bean_test get_bean(){

        return new bean_test("FQ_LOVE",21);
    }

    @Primary
    @Bean
    public bean_test get_bean1(){

        return new bean_test("WQL_LOVE",21);
    }
}
