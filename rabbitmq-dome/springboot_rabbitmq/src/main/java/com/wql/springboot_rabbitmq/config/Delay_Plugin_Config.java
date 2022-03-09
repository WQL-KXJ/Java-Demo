package com.wql.springboot_rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class Delay_Plugin_Config {

    //交换机名称
    String exchange = "Delay_Plugin_Exchange";

    //队列名称
    String queue = "Delay_Plugin_Queue";

    //Routing Key
    String routingkey = "Delay_Plugin";

    //创建交换机
    @Bean(value = "get_delay_plugin_exchange")
    public Exchange get_delay_plugin_exchange(){

        Map<String,Object> arguments = new HashMap<>();
        //需要指定延迟队列的类型
        arguments.put("x-delayed-type","direct");
        //因为我们要声明的类型是x-delayed-message延迟队列类型，使用创建者模式创建没有这个类型选项，所以需要自定义交换机，它也提高CustomExchange让我们自定义
        return new CustomExchange(exchange,"x-delayed-message",true,false,null);
    }

    //创建队列
    @Bean(value = "get_delay_plugin_queue")
    public Queue get_delay_plugin_queue(){
        return QueueBuilder.durable(queue).build();
    }

    //队列绑定
    @Bean
    public Binding delayd_plugin_binding(@Qualifier("get_delay_plugin_queue")Queue queue,@Qualifier("get_delay_plugin_exchange")Exchange exchange){

        return BindingBuilder.bind(queue).to(exchange).with(routingkey).noargs();
    }
}
