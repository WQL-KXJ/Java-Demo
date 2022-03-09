package com;

import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.Scanner;

public class redis_photo {

   static Jedis jedis =new Jedis("192.168.68.153",6379);

    public static void main(String[] args) {

    Boolean exit=exist_math("15326446827");
    if(exit){
        System.out.println("验证成功！");
    }else {
        System.out.println("验证失败！");
    }
    }

    //随机产生6位数手机验证码
    public static String getrandomath(){
        Random random =new Random();

        String randommath ="";

        for(int i=0;i<=5;i++){

            int math = random.nextInt(10);

            randommath+=math;
        }

        return randommath;
    }

    //把验证码放入redis中
    public static void into_redis(String photo){

       String userphoto="userphoto:"+photo;

       //判断数据库中的手机号是否发送验证码超过三次
        if(jedis.get(userphoto)==null){//如果手机号值为空，说明它没有发送过验证码
            jedis.set(userphoto,"0");//设置一个map，key为手机号，value为次数
        }

        if(Integer.parseInt(jedis.get(userphoto))>=2){//判断次数是否大于2

            System.out.println("今天发送次数超过！");
            jedis.close();
        }

        jedis.incr(userphoto);

        String randommath = getrandomath();//获取验证码

        jedis.setex(randommath,2*60,randommath);//设置验证码和过期时间

    }

    //判断验证码是否一致
    public static boolean exist_math(String photo){
        into_redis(photo);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入验证码！！");

        String math=scanner.next();


        if(jedis.get(math)==math){
            return true;

        }

        return false;
    }















}
