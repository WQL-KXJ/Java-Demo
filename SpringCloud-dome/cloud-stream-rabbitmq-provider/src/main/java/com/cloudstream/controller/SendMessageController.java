package com.cloudstream.controller;

import com.cloudstream.service.MessageProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    MessageProviderServiceImpl messageProviderService;

    @GetMapping(value = "/sentmessage")
    public String sent(){
        String send = messageProviderService.send();
        return send;
    }


}
