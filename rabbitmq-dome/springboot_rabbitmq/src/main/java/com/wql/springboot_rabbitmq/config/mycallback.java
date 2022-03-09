package com.wql.springboot_rabbitmq.config;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class mycallback implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnsCallback {


    //因为我们实现是内部类，实现了方法，也并没有加载进ConfirmCallback，需要将当前的类注入进去
    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostConstruct
    //将当前实现类加入到RabbitTemplate.ConfirmCallback
    public void  init(){
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    /*
     * confirm方法：交换机确认回调方法
     * 参数：
     *
     * 1，correlationData：保存消息的ID及相关信息(这个消息可以在发送方进行指定，)
     * 2，b：是否发送成功(true：成功，flase：失败)
     * 3，s：错误信息(发送成功就为null)
     * */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {

        if(b){
            System.out.println("消息发送成功！"+correlationData.getId());
        }else{
            System.out.println("消息发送失败！"+correlationData.getId());
        }
    }

    //该方法可以在消息不可达目的地时，对消息进行回退(只有不可达目的地时才会回退)
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {

        //重新发回退回来的消息
        rabbitTemplate.convertAndSend("confirm_exchange","routingkey",returnedMessage.getMessage());
        System.out.println("消息回退："+returnedMessage.getExchange()+returnedMessage.getMessage());
    }

}
