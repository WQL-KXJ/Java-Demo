package com.wql.springbootfastdfsdome;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FdfsClientConfig.class)//映入Fdfsclient的配置类
public class SpringbootFastdfsDomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFastdfsDomeApplication.class, args);
	}

}

