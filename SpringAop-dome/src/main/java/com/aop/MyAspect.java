package com.aop;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void before(){
        System.out.println("前置增强！");

    }

    public void after(){
        System.out.println("后置增强！");
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前置环绕通知！");
        Object proceed = joinPoint.proceed();
        System.out.println("后置环绕通知！");
         return proceed;
    }

    public void throwing(){
        System.out.println("异常通知！");
    }
    public void end(){
        System.out.println("最终通知！");
    }
}
