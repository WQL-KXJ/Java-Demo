package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect//标注当前类为切面类
public class MyAspect_ann {

    @Before("execution(public void com.aop.proxy.common())")
    public void before(){
        System.out.println("前置增强！");

    }

    @AfterReturning("execution(* com.aop.proxy.*())")
    public void after(){
        System.out.println("后置增强！");
    }

    @Around("execution(* com.aop.proxy.*())")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前置环绕通知！");
        Object proceed = joinPoint.proceed();
        System.out.println("后置环绕通知！");
        return proceed;
    }

    @AfterThrowing("execution(* com.aop.proxy.*())")
    public void throwing(){
        System.out.println("异常通知！");
    }

    @After("execution(* com.aop.proxy.*())")
    public void end(){
        System.out.println("最终通知！");
    }
}
