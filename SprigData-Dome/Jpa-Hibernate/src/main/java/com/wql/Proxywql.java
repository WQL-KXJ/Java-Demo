package com.wql;

import com.dao.pojo.jdbctemplatetestpojo;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxywql implements InvocationHandler {

    EntityManager en;

    Class<jdbctemplatetestpojo> pojoClass;

    public Proxywql() {

    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        MyCustomer myCustomer = new MyCustomer(en,pojoClass);

        Method method1 = myCustomer.getClass().getMethod(method.getName(), method.getParameterTypes());

        Object invoke = method1.invoke(myCustomer, args);

        System.out.print("WQL Love FQ");

        return invoke;}

    public Proxywql(EntityManager en, Class<jdbctemplatetestpojo> pojoClass) {
        this.en = en;
        this.pojoClass = pojoClass;
    }
}
