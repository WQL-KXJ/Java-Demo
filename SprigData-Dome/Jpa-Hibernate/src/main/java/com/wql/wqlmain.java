package com.wql;

import com.config.JpaManagerFoctoryConfig;
import com.dao.pojo.jdbctemplatetestpojo;
import com.dao.repsitories.CustomerRepsitory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Optional;

public class wqlmain {

    public static void main(String[] args) throws ClassNotFoundException {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JpaManagerFoctoryConfig.class);

        LocalContainerEntityManagerFactoryBean bean = applicationContext.getBean(LocalContainerEntityManagerFactoryBean.class);
        EntityManager nativeEntityManager = bean.createNativeEntityManager(null);


        ParameterizedType genericInterfaces = (ParameterizedType)CustomerRepsitory.class.getGenericInterfaces()[0];
        Type actualTypeArguments = genericInterfaces.getActualTypeArguments()[0];
        Class<?> aClass = Class.forName(actualTypeArguments.getTypeName());


        CustomerRepsitory o = (CustomerRepsitory) Proxy.newProxyInstance(
                CustomerRepsitory.class.getClassLoader(),
                new Class[]{CustomerRepsitory.class},
                new Proxywql(nativeEntityManager, (Class<jdbctemplatetestpojo>) aClass)
        );
        Optional<jdbctemplatetestpojo> jdbctemplatetestpojo = o.findById(1);
        System.out.print(jdbctemplatetestpojo.get());


    }
}
