package com.cloud.pymenthystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PymentHystrixMain {

    public static void main(String[] args) {
        SpringApplication.run(PymentHystrixMain.class,args);
    }
    /*此配置是为了服务监控而配置,与服务容错本身无关,
     springcloud升级后的坑servletRegistrationBean因为springboot 的默认S径不是"/hystrix.stream",ا只要在已的下面的servlet就可以
    */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamservlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamservlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings ("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
