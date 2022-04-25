package com.cloud.service;

import com.cloud.service.serviceimpl.feignserviceimpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = feignserviceimpl.class)
public interface feignserver {

    @RequestMapping("/hystrix/ok/{id}")
    public String ok(@PathVariable("id") String id);

    @RequestMapping("/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") String id);
}
