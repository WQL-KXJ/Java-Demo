package com.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

@PropertySource(value = "classpath:/mysql.properties")
@ComponentScan("com.component")
@Configuration
public class datasource_config {

    @Value("${name}")
    String username;

    @Value("${password}")
    String password;

    @Value("${url}")
    String url;

    @Value("${drive}")
    String drive;

    @Bean
    public DataSource get_datasource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(drive);
        return dataSource;
    }

}
