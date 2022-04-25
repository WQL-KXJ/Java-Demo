package com.cloudalibaba.controller;

import com.cloudalibaba.service.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Sentinelfeigncontroller {

    @Autowired
    OpenFeignService openFeignService;

    @GetMapping("/getProvider")
    public String getProvider(){

        String nacosProvider = openFeignService.getNacosProvider();
        return nacosProvider;
    }


}
