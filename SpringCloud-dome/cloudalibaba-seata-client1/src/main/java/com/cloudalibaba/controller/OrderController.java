package com.cloudalibaba.controller;

import com.cloudalibaba.entity.orderpojo;
import com.cloudalibaba.service.OrderServiceImpl;
import com.cloudalibaba.servicefeign.orderfeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    orderfeign orderfeign;

    @GetMapping("/OrderController")
    public String OrderController(orderpojo orderpojo){

        boolean b = orderService.setOrder(orderpojo);
        if(b){
            orderfeign.dw(orderpojo.getProductId());
            return "订单创建成功！！";
        }
        return "订单创建失败！！";
    }
}
