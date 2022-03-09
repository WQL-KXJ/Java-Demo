package com.example.springbootminio.util;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mininconfig {

    @Autowired
    MinioYml minioYml;

    @Bean
    public MinioClient minioClient(){

        MinioClient minioclient = MinioClient.builder().endpoint(minioYml.getEndpoint())
                .credentials(minioYml.getAccessKey(), minioYml.getSecretKey()).build();

        return minioclient;
    }



}
