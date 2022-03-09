package com.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component(value = "postconstruct_test")
public class postconstruct_test {

    public postconstruct_test() {
        System.out.println("无参构造创建对象！");
    }

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct在对象创建完成之后调用！");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("PostConstruct在对象销毁之前调用！");
    }
}
