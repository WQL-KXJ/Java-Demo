package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class zoocontroller {

    @Value("${server.port}")
    String server;

    @RequestMapping("/zk")
    public String gte(){
        return "SpringCloud With Zookeeper："+server+ UUID.randomUUID().toString();
    }
}
