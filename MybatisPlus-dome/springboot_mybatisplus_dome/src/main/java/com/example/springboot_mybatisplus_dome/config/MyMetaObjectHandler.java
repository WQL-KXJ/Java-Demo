package com.example.springboot_mybatisplus_dome.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //获取被标注字段属性的值
        Object name = getFieldValByName("name", metaObject);
        //判断是否为空
        if(name==null){
            //对字段进行填充
            setFieldValByName("name","GUN",metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
