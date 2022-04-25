package com.cloud.controller;

import com.cloud.commons.entities.payment;
import com.cloud.service.PaymentFeignService;
import com.cloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource//注入OpenFeign接口
    PaymentFeignService feignService;

    @RequestMapping("/consumer/payment/select/{id}")
    public CommonResult<payment> select(@PathVariable("id") int id){
        return feignService.select(id);
    }

    @RequestMapping("/payment/time")
    public String timeout(){
        return feignService.timeout();
    }

}
