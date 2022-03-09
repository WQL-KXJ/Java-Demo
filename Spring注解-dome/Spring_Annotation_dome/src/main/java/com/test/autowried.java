package com.test;

import com.bean.bean_test;
import com.config.autowried_config;
import com.config.inject_config;
import com.config.resource_config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {autowried_config.class, resource_config.class, inject_config.class})
public class autowried {

    //required = false假如没有装配的bean就返回空，这样不会报错
    @Qualifier(value = "get_bean4")
    @Autowired(required = false)
    bean_test get_bean3;

    @Resource(name = "get_bean_test")
    bean_test bean;


    @Inject
    bean_test bean1;

    @Test
    public  void test(){

        System.out.println(get_bean3);

    }
    @Test
    public  void test1(){
        System.out.println(bean);
    }

    @Test
    public  void test2(){
        System.out.println(bean1);
    }
}
