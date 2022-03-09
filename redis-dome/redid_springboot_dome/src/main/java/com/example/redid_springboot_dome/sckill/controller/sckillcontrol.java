package com.example.redid_springboot_dome.sckill.controller;

import com.example.redid_springboot_dome.sckill.service.Seckillservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class sckillcontrol {

    //秒杀的service
    @Autowired
    Seckillservice seckillservice;

    //虚拟用户id
    Random random = new Random();

    @RequestMapping("/seckill")
    @ResponseBody
    public String seckill(){

        //没有前端，固定商品id
        String commodity_id="1001";

        //每一次秒杀随机用户id
        int userid = random.nextInt(1000);

        //传入service
        boolean b = seckillservice.seckill_service(commodity_id, userid);
        if(!b){
            return "秒杀失败！";
        }
        return "秒杀成功！";
    }


}
