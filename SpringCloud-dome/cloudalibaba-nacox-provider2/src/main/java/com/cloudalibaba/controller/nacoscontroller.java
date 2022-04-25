package com.cloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class nacoscontroller {

    @Value("${server.port}")
    String port;

    @GetMapping(value = "/pyment/nacos/{id}")
    public String getnacos(@PathVariable("id") Integer id){

        return "nacos registory serverport:"+port+"--->"+id;

    }
}
