package com.springwql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;

@Component(value = "a")
public class zhujewql2 {
    /*
    * 基于注解实现注入：
    *  @Autowired:根据属性类型自动装配
    *  @Qualifier:根据属性名自动装配（它和Autowired一起使用）
    *  @Resource:可以根据类型也可以根据名称装配
    *  @Value:属性基本类型注入
    *
    *
    *
    * */
    @Autowired
    @Qualifier(value = "q")
    zhujewql a;

    public void i(){
        a.f();
    }


}
