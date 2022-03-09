package com.example.springbootminio.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioYml {

    private String endpoint;
    private String accessKey;
    private String secretKey;

}
