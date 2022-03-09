package com.WQL.config;

import com.WQL.server.interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class interceptor_coonfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        interceptor i = new interceptor();
        InterceptorRegistration registration = registry.addInterceptor(i);
        registration.addPathPatterns("/*");
    }
}
