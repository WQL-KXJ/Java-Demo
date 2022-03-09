package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@PropertySource("classpath:/jdbc.properties")
@Configuration
public class c3p0_config {

    @Value("${username}")
    String username;
    @Value("${password}")
    String password;
    @Value("${drive}")
    String drive;

    @Profile("test")
    @Bean("testDataSource")
    public DataSource devDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource =new ComboPooledDataSource();
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        comboPooledDataSource.setDriverClass(drive);
        return comboPooledDataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource proDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource =new ComboPooledDataSource();
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/wql");
        comboPooledDataSource.setDriverClass(drive);
        return comboPooledDataSource;
    }

    @Profile("pro")
    @Bean("proDataSource")
    public DataSource dataSource2() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource =new ComboPooledDataSource();
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/bookstrom");
        comboPooledDataSource.setDriverClass(drive);
        return comboPooledDataSource;
    }
}


