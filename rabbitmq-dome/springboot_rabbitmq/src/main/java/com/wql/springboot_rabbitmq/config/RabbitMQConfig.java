package com.wql.springboot_rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Exchange;
//配置类
//@Configuration
public class RabbitMQConfig  {

    //交换机
    @Bean("bootexchange")
    public Exchange bootexchange(){
        //通过ExchangeBuilder构建fanout类型名称为springboot_exchange的交换机
        return ExchangeBuilder.fanoutExchange("springboot_exchange").durable(true).build();
    }

    //队列
    @Bean("bootqueue")
    public Queue bootqueue(){
        //构建queue，名称在durable中指定
        return QueueBuilder.durable("springboot_queue").build();
    }

    //交接机合队列绑定
    @Bean
    public Binding bindexchangequeue(@Qualifier("bootqueue") Queue queue, @Qualifier("bootexchange") Exchange exchange){
    /*
    * bind：需要绑定的队列
    * to：需要绑定的交换机
    * with：指定routingkey
    * noargs：构建
    * and：参数
    * */
    return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }

}
