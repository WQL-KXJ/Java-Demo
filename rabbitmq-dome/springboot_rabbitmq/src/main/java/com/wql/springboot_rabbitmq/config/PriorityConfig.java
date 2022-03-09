package com.wql.springboot_rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PriorityConfig {

    //交换机名称
    String priority_exchange = "priority_exchange";
    //优先级队列名称
    String priority_queue = "priority_queue";

    //交换机
    @Bean("get_priority_exchange")
    public Exchange get_priority_exchange(){

        return ExchangeBuilder.fanoutExchange(priority_exchange).durable(true).durable(true).build();
    }

    //队列
    @Bean("get_priority_queue")
    public Queue get_priority_queue(){
        Map<String,Object> argument = new HashMap();
        //设置优先级,最高优先级为10
        argument.put("x-max-priority","10");
        //构建queue，名称在durable中指定
        return QueueBuilder.durable(priority_queue).withArguments(argument).build();
    }

    //绑定
    @Bean
    public Binding dead_binding(@Qualifier("get_priority_queue") Queue queue, @Qualifier("get_priority_exchange")Exchange exchange){

        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }
}
