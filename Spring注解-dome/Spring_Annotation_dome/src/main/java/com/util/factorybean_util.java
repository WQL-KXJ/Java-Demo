package com.util;

import com.bean.condition_test;
import org.springframework.beans.factory.FactoryBean;

public class factorybean_util implements FactoryBean {

    //返回一个对象，这个对象会添加到容器中
    @Override
    public Object getObject() throws Exception {
        //返回一个condition_test对象
        return new condition_test("FactoryBean");
    }

    //返回对象的类型
    @Override
    public Class<?> getObjectType() {
        //返回对象condition_test类型
        return condition_test.class;
    }

    //是否为单例，返回true为单例，返回flase为多例
    @Override
    public boolean isSingleton() {
        //为单例
        return true;
    }
}
