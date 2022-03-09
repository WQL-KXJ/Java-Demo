package com.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//@Component(value = "InitialliazingBean_test")
public class InitialliazingBean_test implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("InitializingBean初始化！");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean销毁！");
    }

    public InitialliazingBean_test() {

        System.out.println("有参构建bean对象！");
    }
}
