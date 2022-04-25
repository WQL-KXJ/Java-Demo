package com.cloud.service;

import com.cloud.commons.entities.payment;
import com.cloud.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVER" )//value为连接的服务名称
public interface PaymentFeignService {
    @RequestMapping("/payment/select/{id}")//服务应用程序里面对应的接口地址,底层通过Ribbon进行调用
    public CommonResult<payment> select(@PathVariable("id") int id);
    @RequestMapping("/payment/time")
    public String timeout();
}
