package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${wql}")
    String wlq;

    @Value("${config.info}")
    String info;

    @GetMapping("/getapplication")
    public String get(){

        return "{wql:"+wlq+",info:"+info+"}";
    }
}
