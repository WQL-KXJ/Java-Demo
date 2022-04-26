package com.example.cloudalibabaseatatest.controller;


import com.example.cloudalibabaseatatest.entity.orderpojo;
import com.example.cloudalibabaseatatest.feignservice.orderfeign;
import com.example.cloudalibabaseatatest.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;


    @GetMapping("/OrderController")
    public String OrderController(orderpojo orderpojo){

        boolean b = orderService.setOrder(orderpojo);
        if(b){

            return "订单创建成功！！";
        }
        return "订单创建失败！！";
    }
}
