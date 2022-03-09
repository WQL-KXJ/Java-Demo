package com.example.bootserverconsumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDubbo//dubbo的包扫描
@EnableHystrix
@SpringBootApplication
public class BootServerConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootServerConsumerApplication.class, args);
	}

}
