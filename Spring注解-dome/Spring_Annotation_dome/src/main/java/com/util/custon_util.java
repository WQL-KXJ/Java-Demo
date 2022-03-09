package com.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class custon_util implements TypeFilter {
    //
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //1，获取当前类注解信息(有获取注解名，注解类型等方法)
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //2，获取当前类的类信息(有获取类的名称，实现接口，子类，继承类等方法)
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //3，获取当前类资源路径(获取类的文件名称，文件路径，URL等方法)
        Resource resource = metadataReader.getResource();

        //打印类名称
        String classname = classMetadata.getClassName();
        System.out.println(classname);

        //假如类名包含bean就返回true表示匹配
        if(classname.contains("bean")){
            return true;
        }
        return false;
    }
}
