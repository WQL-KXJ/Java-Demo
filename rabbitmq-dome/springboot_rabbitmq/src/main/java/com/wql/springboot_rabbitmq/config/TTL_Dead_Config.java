package com.wql.springboot_rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class TTL_Dead_Config {

    //普通交换机和普通队列的名称
    String com_exchange = "com_delay_exchange";
    String com_queue = "com_delay_queue";

    //死信交换机和死信队列(也叫延迟交换机和延迟队列)
    String delay_exchange = "delay_exchange";
    String delay_queue = "delay_queue";

    //声明普通交换机
    @Bean(value = "get_com_exchange")
    public Exchange get_com_exchange(){


        return ExchangeBuilder.directExchange(com_exchange).durable(true).build();
    }

    //声明死信交换机
    @Bean(value = "get_delay_exchange")
    public Exchange get_delay_exchange(){

        return ExchangeBuilder.directExchange(delay_exchange).durable(true).build();
    }

    //声明死信队列
    @Bean(value = "get_delay_queue")
    public Queue get_delay_queue(){

        return QueueBuilder.durable(delay_queue).build();
    }

    //声明普通队列
    @Bean(value = "get_com_queue")
    public Queue get_com_queue(){
        //参数map
        Map<String,Object> argument = new HashMap<>();
        //绑定死信交换机
        argument.put("x-dead-letter-exchange",delay_exchange);
        //设置绑定Routing Key
        argument.put("x-dead-letter-routing-key","delay");
        //设置message的TTL过期时间
        argument.put("x-message-ttl",100000);

        return QueueBuilder.durable(com_queue).withArguments(argument).build();
    }

    //普通队列绑定
    @Bean
    public Binding com_binding(@Qualifier("get_com_queue") Queue queue,@Qualifier("get_com_exchange") Exchange exchange){

        return BindingBuilder.bind(queue).to(exchange).with("com_queue").noargs();
    }

    //死信队列绑定
    @Bean
    public Binding dead_binding(@Qualifier("get_delay_queue") Queue queue,@Qualifier("get_delay_exchange")Exchange exchange){

        return BindingBuilder.bind(queue).to(exchange).with("delay").noargs();
    }


}
