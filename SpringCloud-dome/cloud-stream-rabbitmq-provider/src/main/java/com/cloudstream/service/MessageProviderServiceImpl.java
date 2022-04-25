package com.cloudstream.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@Slf4j
@EnableBinding(Source.class) //定义消息的推送管道，生产端使用Source(固定写法)，注意引入的包是Stream提供的
public class MessageProviderServiceImpl implements MessageProviderService {

    @Resource
    MessageChannel output; //消息发送的管道

    @Override
    public String send() {
        String uuid = "WQL-Cloud-Stream："+UUID.randomUUID().toString();
        //发送消息
        boolean send = output.send(MessageBuilder.withPayload(uuid).build());
        if (send){
            log.info("发送成功："+uuid);
            return "发送成功";
        }
        return "发送失败";
    }
}
