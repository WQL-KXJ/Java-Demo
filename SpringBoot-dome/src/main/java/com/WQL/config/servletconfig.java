package com.WQL.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class servletconfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        //new一个servlet对象
        servlet_my servlet =new servlet_my();
        //并把它加入springboot提供的servlet容器中
        return new ServletRegistrationBean(servlet,"/mywql");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        //new一个filter对象
        servletfilter_my servletfilterMy = new servletfilter_my();
        //并把它加入springboot提供的filter容器中
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(servletfilterMy);
        //加入过滤的路径
        filterRegistrationBean.addUrlPatterns("/mywql");
        return filterRegistrationBean;
    }


    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){

        //new一个listener对象
        servletlistener_my servletlistenerMy = new servletlistener_my();
        //将listener对象加入容器中
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(servletlistenerMy);
        //返回
        return servletListenerRegistrationBean;
    }

}
