package com.spring_rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class spring_rabbitmq_consumer implements MessageListener {
    //通过这个onMessage方法获取数据
    @Override
    public void onMessage(Message message) {
        //message为数据对象
        System.out.println(new String(message.getBody()));
    }
}
