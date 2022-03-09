package com.util;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

//手动注册组件
public class ImportBeanDefinitionRegistrar_util implements ImportBeanDefinitionRegistrar {

    /*
    *参数：
    * 1，AnnotationMetadata：当前类的注解信息
    * 2，BeanDefinitionRegistry：BeanDefinition注册类，通过这个类的方法进行手动注册
    *   registry.registerBeanDefinition():手动注册方法
    * */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
    }
}
