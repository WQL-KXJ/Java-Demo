package com.swg.controller;

import com.swg.entity.wql;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Author WQL-KXJ
 * @ProjectName Swagger-Dome
 * @PackageName com.swg.controller
 * @Date 2022/7/31 0:24
 * @Version 1.0
 */
@RestController
public class swaggertest2 {

    @GetMapping("/wql-kxj")
    public wql getswagger(String user, Integer password){
        return new wql();
    }

}
