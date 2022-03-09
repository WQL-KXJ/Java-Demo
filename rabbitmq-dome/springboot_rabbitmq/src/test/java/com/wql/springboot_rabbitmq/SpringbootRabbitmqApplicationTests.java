package com.wql.springboot_rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.impl.AMQBasicProperties;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {

    //springboot和spring一样都是通过RabbitTemplate进行发送消息，只不管springboot不需要在配置文件中指定RabbitTemplate，直接可以注入
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //RabbitMQ和SpringBoot整合测试
    @Test
    void contextLoads() {
        //发送消息
        for (int a=0;a<=20;a++) {
            rabbitTemplate.convertAndSend("springboot_exchange", "", "springboot整合rabbitmq！！！");
        }
    }

    //TTL延迟队列测试
    @Test
    public void delay_queue_test(){

        for (int a=0;a<=20;a++) {
            rabbitTemplate.convertAndSend("com_delay_exchange", "com_queue", "TTL+死信队列实现延迟队列！！",msg ->{
                msg.getMessageProperties().setExpiration("100000");
                return msg;
            });
        }
    }
    //exchange确认发布测试
    @Test
    public void configfrim(){

        CorrelationData correlationData = new CorrelationData();
        correlationData.setId("WQL_ID");
        for (int a=0;a<=20;a++) {
            //将队列的名称改成不存在，看消费是否进行回调确认
            rabbitTemplate.convertAndSend("confirm_exchange", "routingkey", "高级发布确认！",correlationData);
        }
    }

    //备份交换机测试
    @Test
    public void backup_exchange(){
        for (int a=0;a<=20;a++) {
            //将队列的Routing key改成不存在，看消费是否转发到备份交换机
            rabbitTemplate.convertAndSend("confirm_exchange", "rout", "备份交换机转发！");
        }
    }

    //优先级队列测试
    @Test
    public void priorityqueue(){


        //发送消息
        for(int a=0;a<10;a++){

            rabbitTemplate.convertAndSend("priority_exchange","","优先级队列！6",message -> {
                message.getMessageProperties().setPriority(7);
                return message;
            });
            if(a>5) {
                rabbitTemplate.convertAndSend("priority_exchange","","优先级队列！8",message -> {
                    message.getMessageProperties().setPriority(8);
                    return message;
                });
            }
        }
    }


}
