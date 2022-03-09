package com.wql.springboot_rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

//发布确认高级版
//@Configuration
public class ConfirmConfig {

    //交换机名称
    String exchange = "confirm_exchange";
    //队列名称
    String queue = "confirm_queue";
    //RoutingKey
    String routingkey = "routingkey";

    //备份交换机名称
    String backup_exchange ="backup_exchange";
    //备份队列
    String backup_queue = "backup_queue";


    //声明主交换机
    @Bean("get_confirm_exchange")
    public Exchange get_confirm_exchange(){
        Map<String,Object> arguments = new HashMap<>();
        //主交换机绑定备份交换机
        arguments.put("alternate-exchange",backup_exchange);
        return ExchangeBuilder.directExchange(exchange).durable(true).withArguments(arguments).build();
    }

    //声明主队列
    @Bean("get_confirm_queue")
    public Queue get_confirm_queue(){

        return QueueBuilder.durable(queue).build();
    }

    //声明备份交换机
    @Bean("get_backup_exchange")
    public Exchange get_backup_exchange(){

        return ExchangeBuilder.fanoutExchange(backup_exchange).durable(true).build();
    }

    //声明备份交换机队列
    @Bean("get_backup_queue")
    public Queue get_backup_queue(){

        return QueueBuilder.durable(backup_queue).build();
    }

    //备份交换机和队列绑定
    @Bean
    public Binding backup_binding(@Qualifier("get_backup_queue") Queue queue,@Qualifier("get_backup_exchange") Exchange exchange){

        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }
    //主交换机和队列绑定
    @Bean
    public Binding exchange_binding_queue(@Qualifier("get_confirm_queue") Queue queue,@Qualifier("get_confirm_exchange") Exchange exchange ){

        return BindingBuilder.bind(queue).to(exchange).with(routingkey).noargs();
    }


}
