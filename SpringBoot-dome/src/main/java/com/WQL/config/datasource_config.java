package com.WQL.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

//声明配置类
//@Configuration
@Deprecated
public class datasource_config {

    //自定义Druid数据源并返回
    @Bean
    //将DataSource中的属性跟配置文件中属性进行绑定，这样就可以修改propreties或yaml配置文件配置数据库连接
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid_datasource() throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();

        //开启数据源监控功能
        druidDataSource.setFilters("stat,wall");

        /*假如没有提供ConfigurationProperties跟配置文件绑定就需要在这个方法中配置连接信息
            druidDataSource.setPassword();
            druidDataSource.setUsername();
            druidDataSource.setDriver();
            druidDataSource.setUrl();
         */
        return druidDataSource;
    }
    /*配置StatviewServlet开启监控页*/
    @Bean
    public ServletRegistrationBean statviewservlet(){
        //创建druid监控页
        StatViewServlet statViewServlet = new StatViewServlet();

        //将对象放如ServletRegistrationBean中并声明监控页的路径
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        //设置监控页的账号秘密
        statViewServletServletRegistrationBean.addInitParameter("loginUsername","admin");
        statViewServletServletRegistrationBean.addInitParameter("loginPassword","123");
        //返回
        return statViewServletServletRegistrationBean;
    }

    /*配置WebStatFilter开启WEB监控*/
    @Bean
    public FilterRegistrationBean webstatfilter(){

        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<WebStatFilter>(webStatFilter);
        //设置拦截的路径，设置未/*拦截所有路径，所有的web请求都监控
        webStatFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        //不拦截静态资源请求，设置初始化参数为exclusions
        webStatFilterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.jpg,*.png,*.css,*.html,*.ico,/druid/*");
        return webStatFilterFilterRegistrationBean;
    }

}
