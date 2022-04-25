package com.cloudalibaba.service;

import org.springframework.stereotype.Component;

@Component
public class FallBackServiceImpl implements OpenFeignService {
    @Override
    public String getNacosProvider() {
        return "OpenFeign Sentinel 整合--->FallBack触发";
    }
}
