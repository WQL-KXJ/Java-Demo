package com.cloud.controller;

import com.cloud.service.feignserver;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//@DefaultProperties(defaultFallback = "hystrix_fallback")
public class hystrixorder {

    @Resource
    feignserver feignserver;

    @RequestMapping("/hystrixorder/ok/{id}")
    public String ok(@PathVariable("id") String id){

        return feignserver.ok(id);
    }

    @RequestMapping("/hystrixorder/timeout/{id}")
    @HystrixCommand
    public String timeout(@PathVariable("id") String id){

        return feignserver.timeout(id);
    }

    public String hystrix_fallback(@PathVariable("id") String id){

        return "服务出现超时或者错误，请稍后再试！";
    }
}
