package com.cloudstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudStreamConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamConsumerMain.class,args);
    }
}
