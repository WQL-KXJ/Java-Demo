package com.cloud.pymenthystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class pymentservice {

    public String paymentinfo_Ok(String id){
        return "线程"+Thread.currentThread().getName()+"paymentinfo_Ok:id"+id;

    }

    @HystrixCommand(fallbackMethod = "paymentinfo_Hander",
                    commandProperties = {
                                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3 000")
                    })
    public String paymentinfo_TimeOut(String id){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        return "线程"+Thread.currentThread().getName()+"paymentinfo_TimeOut:id"+id;
    }

    public String paymentinfo_Hander(String id){

        return "线程:"+Thread.currentThread().getName()+id+" --> 服务超时或者错误！请稍后在试!";

    }


}
