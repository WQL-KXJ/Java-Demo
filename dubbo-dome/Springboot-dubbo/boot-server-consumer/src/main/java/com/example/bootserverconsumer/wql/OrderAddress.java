package com.example.bootserverconsumer.wql;


import com.example.bootserverprovider.bean.UserAdress;
import com.example.bootserverprovider.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class OrderAddress {

    @DubboReference()
    UserService userService;

    @HystrixCommand(fallbackMethod ="err" )//fallbackMethod回调方法，一旦调用远程服务出错，调用会调方法
    public List<UserAdress> getwql(){


        return userService.getbean();
    }

    @GetMapping(value = "/")
    @ResponseBody
    public List<UserAdress> err(){//定义回调方法

        return Arrays.asList(new UserAdress("回调方法","测试回调"));
    }
}
