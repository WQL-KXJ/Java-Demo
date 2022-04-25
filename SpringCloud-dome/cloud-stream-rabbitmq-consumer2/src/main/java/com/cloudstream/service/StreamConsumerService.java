package com.cloudstream.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableBinding(Sink.class)//服务消费者，消费者使用Sink.class
public class StreamConsumerService {
    @Value("${server.port}")
    String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){

        String payload = "服务消费者1："+port+" ----> "+message.getPayload();
        log.info(payload);
    }
}
