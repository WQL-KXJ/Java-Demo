package com.cloud.pymenthystrix.controller;

import cn.hutool.core.util.IdUtil;
import com.cloud.pymenthystrix.service.pymentservice;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class paymentcontroll {

    @Resource
    pymentservice pymentservice;

    @Value("${server.port}")
    String port;

    @RequestMapping("/hystrix/ok/{id}")
    public String ok(@PathVariable("id") String id){
        String s = pymentservice.paymentinfo_Ok(id);
        log.info(s);
        return s;
    }

    @RequestMapping("/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") String id){
        String s = pymentservice.paymentinfo_TimeOut(id);
        log.info(s);
        return s;
    }


    @RequestMapping("/hystrix/breaker/{id}")
    @HystrixCommand(fallbackMethod ="fashingCiruitBreaker",
                    commandProperties = {
                            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启熔断
                            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
                            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
                            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少进行熔断
                    })
    public String paymentCiruitBreaker(@PathVariable("id") Integer id){

        if(id<0){
            throw new RuntimeException("id不能为负数，/(ㄒoㄒ)/~~");
        }
        String s = IdUtil.simpleUUID();

        return "订单流水号："+s;
    }

    public String fashingCiruitBreaker(@PathVariable("id") Integer id){

        return "熔断！！！";
    }

}
