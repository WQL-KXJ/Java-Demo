package com.example.redid_springboot_dome.sckill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class Seckillservice {

    @Autowired
    RedisTemplate redisTemplate;

    public boolean seckill_service(String commodityid,int userid){
        //这个对象一次被一个线程调用，所有操作redistemplate都必须放在这个
        SessionCallback<List> sessionCallback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                //1,判断商品id和用户id是否为空
                if(commodityid.equals("") || userid==0 ){
                    return null;
                }
                //2,对commodityid和userid做为key进行拼接
                String commodity = "commodit:"+commodityid;
                String user = "user:size";
                //监听方法必须放在所有redis方法的最前面，不然高并发时会被其他方法干扰
                redisTemplate.watch(commodity);

                //3,判断redis中commodityid是否存在，不存在则秒杀没有开始
                Integer quantity  = (Integer) redisTemplate.opsForValue().get(commodity);
                if(quantity==null){
                    System.out.println("秒杀未开始！");
                    return null;
                }
                //4,判断commodity是否还要库存
                if(quantity<=0){
                    System.out.println("库存不够！");
                    return null;
                }

                //5,判断用户是否重复操作
                if(redisTemplate.opsForSet().isMember(user,userid)){
                    System.out.println("用户重复操作！");
                    return null;
                }

                //开启事务
                redisOperations.multi();
                //6，秒杀库存
                //库存减一
                redisOperations.opsForValue().decrement(commodity);
                //秒杀成功的用户添加到用户set集合中
                redisOperations.opsForSet().add(user,userid);
                List exec = redisOperations.exec();
                return exec;
            }
        };

        redisTemplate.multi();
        //提交事务
        List execute = (List) redisTemplate.execute(sessionCallback);
        if(execute==null || execute.size()==0){
            System.out.println("秒杀失败");
            return false;
        }else {
        return true;
    }}
}
/*
* */