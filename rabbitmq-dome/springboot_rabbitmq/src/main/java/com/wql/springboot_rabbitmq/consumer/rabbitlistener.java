package com.wql.springboot_rabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class rabbitlistener{

    @RabbitListener(queues = "springboot_queue")
    public void listenr_consumer(Message message){

        System.out.println(new String(message.getBody()));

    }


    //消费死信队列
    @RabbitListener(queues = "delay_queue")
    public void listenr_delay_queue(Message message){
        System.out.println(new String(message.getBody()));
    }

    //消费主队列
    @RabbitListener(queues = "confirm_queue")
    public void confirm(Message message){
        System.out.println(new String(message.getBody()));
    }

    //消费备份队列
    @RabbitListener(queues = "backup_queue")
    public void backup_consumer(Message message){
        System.out.println(new String(message.getBody()));
    }

    //消费优先级队列
    @RabbitListener(queues = "priority_queue")
    public void priority_consumer(Message message){
        System.out.println(new String(message.getBody()));
    }
}
