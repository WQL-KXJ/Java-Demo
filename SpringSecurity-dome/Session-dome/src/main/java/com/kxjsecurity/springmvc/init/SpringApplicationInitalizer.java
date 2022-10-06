package com.kxjsecurity.springmvc.init;

import com.kxjsecurity.springmvc.config.WebConfig;
import com.kxjsecurity.springmvc.config.applicationConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * @Author WQL-KXJ
 * @ProjectName Session-dome
 * @PackageName com.kxjsecurity.springmvc.config
 * @Date 2022/8/6 22:12
 * @Version 1.0
 */
public class SpringApplicationInitalizer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //指定rootContext的配置类
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{applicationConfig.class};
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
