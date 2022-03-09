package com.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessor_test implements BeanPostProcessor {

    @Override
    /*前置处理器
    * 参数：
    * 1，Object bean：容器中传入的bean实例
    * 2，String beanName：bean名称
    * 处理完成后需要将bean进行返回
    * */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization——>前置处理器："+beanName);
        return bean;
    }

    @Override
    //后置处理器
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization——>后置处理器："+beanName);
        return bean;
    }
}
