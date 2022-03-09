package com.util;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class condition_win_util implements Condition {
    /*
    * 匹配成功就返回true，失败就为false
    * ConditionContext：上下文
    * metadata：注释信息
    * */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        //1,获取bean工厂对象
        ConfigurableListableBeanFactory factory = context.getBeanFactory();

        //2,获取类加载器
        ClassLoader classLoader = context.getClassLoader();

        //3,获取当前环境信息
        Environment environment = context.getEnvironment();

        //4,获取到bean的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        //通过environment获取当前系统的类型
        String os_name = environment.getProperty("os.name");

        //判断当前系统是为linux还是windown
        if(os_name.contains("Windows")){
            return true;
        }
        return false;
    }
}
