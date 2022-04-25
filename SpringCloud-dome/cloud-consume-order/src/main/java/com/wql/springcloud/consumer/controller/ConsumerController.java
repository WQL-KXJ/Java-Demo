package com.wql.springcloud.consumer.controller;

import com.cloud.commons.entities.payment;
import com.wql.springcloud.consumer.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVER";

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/payment/create",method = RequestMethod.GET)
    public CommonResult<payment> create(payment payments){

       return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payments,CommonResult.class);

    }

    @RequestMapping("/payment/select/{id}")
    public CommonResult<payment> select(@PathVariable("id") int id){

        return  restTemplate.getForObject(PAYMENT_URL+"/payment/select/"+id,CommonResult.class);
    }

    @GetMapping("/discovery")
    public Object get_server(){

        //获取注册的服务列表
        List<String> services = discoveryClient.getServices();
        for(String server:services){
            log.info("-----"+server+"------");
        }
        //提供服务名获取具体的服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        for(ServiceInstance server:instances){
            log.info("服务地址："+server.getHost()+"\t"+"服务接口："+server.getPort()+"服务URL："+server.getUri()+"服务ID："+server.getServiceId());
        }
        return this.discoveryClient;
    }


}
