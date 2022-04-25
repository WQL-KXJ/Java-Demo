package com.cloudalibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cloudalibaba-sentinelmain-service",fallback = FallBackServiceImpl.class)
public interface OpenFeignService {

    @RequestMapping("/testA")
    String getNacosProvider();

}
