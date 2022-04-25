package com.cloud.service.serviceimpl;

import com.cloud.service.feignserver;
import org.springframework.stereotype.Component;

@Component
public class feignserviceimpl implements feignserver {
    @Override
    public String ok(String id) {
        return "服务出现超时或者错误，请稍后再试!!";
    }

    @Override
    public String timeout(String id) {
        return "服务出现超时或者错误，请稍后再试!!";
    }
}
