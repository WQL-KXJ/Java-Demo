package com.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //Nacos注册发现
@EnableFeignClients //OpenFeign的支持
public class SentinelOpenfeignMain {
    public static void main(String[] args) {
        SpringApplication.run(SentinelOpenfeignMain.class,args);
    }
}
