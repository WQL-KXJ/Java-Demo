package com.example.bootserverprovider.service.serviceimpl;

import com.example.bootserverprovider.bean.UserAdress;
import com.example.bootserverprovider.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service//暴露服务
@DubboService
public class UserServiceimpl implements UserService {

    @HystrixCommand//使用Hystrix来带来这个方法的异常
    public List<UserAdress> getbean() {

        if(Math.random()>0.5){

            throw  new RuntimeException();

        }
        System.out.println("userserver 3号机服务被调用");

        UserAdress wql1 = new UserAdress("WQL", "湖南衡阳！");

        UserAdress wql2 = new UserAdress("FQ","深圳");

        List<UserAdress> list = new ArrayList<UserAdress>();

        list.add(wql1);
        list.add(wql2);


        return list;
    }
}
