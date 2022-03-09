package com.aop;

import org.springframework.stereotype.Component;

@Component
public class proxy implements proxy_interface {
    public void common() {

        System.out.println("Run!!!");
    }
}
