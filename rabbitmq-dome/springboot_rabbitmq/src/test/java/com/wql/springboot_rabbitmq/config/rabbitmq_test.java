package com.wql.springboot_rabbitmq.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class rabbitmq_test_wql {
    //springboot和spring一样都是通过RabbitTemplate进行发送消息，只不管springboot不需要在配置文件中指定RabbitTemplate，直接可以注入
    @Autowired
    private RabbitTemplate template;


}
