package com.springwql;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect //表示它是一个增强类
public class proxywql2 {
/*
* aop术语：
* 1，连接点：可以被增强的方法
* 2，切入点：实际被增强的方法
* 3，通知：实际被增强的逻辑部分
*    通知的多种分类：
*                 前置通知(@Before)：在增强方法在被代理的实际方法之前执行
*                 后置通知(@After):在实际方法之后执行
*                 环绕通知(@Around):在实际方法前后都执行
*                 异常通知(@AfterThrowing):在实际方法出现异常之后执行
*                 最终通知(@AfterReturning):最终通知
*  @After 和 @AfterReturning的区别：
*                                @After：在方法执行之后之后执行
*                                @AfterReturning：在方法返回结果之后执行
*
* 当多个增强类增强同一个方法可以通过@Order设置优先极：数组越小优先级越高
*
* 4，切面：是一种动作，方法增强的过程
*
*
* */

@Before("execution(* com.springwql.proxywql.wql())")
public void wql1(){
System.out.print("代理");
}}
