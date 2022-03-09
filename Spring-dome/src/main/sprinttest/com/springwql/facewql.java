package com.springwql;

import org.springframework.beans.factory.FactoryBean;
//工厂bean和普通bean的区别，普通bean设置声明类型就返回声明类型，工厂bean可以更改类型
//工厂bean要继承String中FactoryBean接口
public class facewql implements FactoryBean {

    public Object getObject() throws Exception {
        FQLOVE a=new FQLOVE();
        a.a="工厂bean";
        return a;
    }

    public Class<?> getObjectType() {
        return null;
    }
}
