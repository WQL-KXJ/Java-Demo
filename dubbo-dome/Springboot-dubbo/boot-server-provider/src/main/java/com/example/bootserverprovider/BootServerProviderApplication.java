package com.example.bootserverprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@EnableDubbo
@EnableHystrix//开启服务容错
@SpringBootApplication
public class BootServerProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootServerProviderApplication.class, args);
	}

}
