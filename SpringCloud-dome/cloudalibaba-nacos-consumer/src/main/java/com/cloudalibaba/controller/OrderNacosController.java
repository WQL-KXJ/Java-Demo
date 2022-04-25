package com.cloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderNacosController {

    @Resource
    RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    String httpaddr;

    @GetMapping(value = "/consumer/nacos/{id}")
    public String pymentinfo(@PathVariable("id") Integer id){

      return  restTemplate.getForObject(httpaddr+"/pyment/nacos/"+id,String.class);
    }
}
