package com.sentinelgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelGateWayMain2 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelGateWayMain2.class,args);
    }
}
