package com.kxjsecurity.init;

import com.kxjsecurity.config.WebConfig;
import com.kxjsecurity.config.WebSecurityConfig;
import com.kxjsecurity.config.applicationConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * @Author WQL-KXJ
 * @ProjectName Spring-SpringSecurity-Dome
 * @PackageName com.kxjsecurity.init
 * @Date 2022/8/12 22:40
 * @Version 1.0
 */
public class SpringApplicationInitalizer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //指定rootContext的配置类
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{applicationConfig.class, WebSecurityConfig.class};
    }

    //指定servletContext的配置类
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //url-map
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
