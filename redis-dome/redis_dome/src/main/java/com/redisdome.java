package com;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class redisdome {

    public static void main(String[] args) {

        //创建jedis，建立连接
        Jedis jedis =new Jedis("192.168.68.153",6379);

        //测试是否能连接
        String ping=jedis.ping();//有返回值就ping通
        System.out.println(ping);

       Set<String> set= jedis.keys("*");

       for(String a:set){

           System.out.println(a);

       }

    }
}
