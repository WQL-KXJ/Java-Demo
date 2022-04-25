package com.cloud;

import com.myrule.MySelfRlue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVER",configuration = MySelfRlue.class)
public class RibbonMain {
    public static void main(String[] args) {

        SpringApplication.run(RibbonMain.class,args);

    }
}
