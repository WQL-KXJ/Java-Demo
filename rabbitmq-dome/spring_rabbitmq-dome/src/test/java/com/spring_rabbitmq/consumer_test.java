package com.spring_rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-consumer.xml")
//测试消费者
public class consumer_test {

    //这个测试方法目的不是调用bean，通过ContextConfiguration运行这个配置文件即可
    @Test
    public void consumer_test_wql() {}
}
