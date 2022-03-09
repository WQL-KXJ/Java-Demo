package com.example.springbootminio;

import io.minio.MinioClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMinioApplicationTests {

	@Autowired
	MinioClient minioClient;

	@Test
	void contextLoads() {
		

	}

}
