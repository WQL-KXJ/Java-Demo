package com.springwql;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class springmain {
    @Test
    public void fq(){
        //bean创建
        BeanFactory factory=new ClassPathXmlApplicationContext("wql.xml");
        FQLOVE a=(FQLOVE) factory.getBean("fq");
        a.add();

    }

    @Test
    public void fq1(){
        //依赖注入
        BeanFactory factory=new ClassPathXmlApplicationContext("wql1.xml");
        FQLOVE a=(FQLOVE) factory.getBean("fq");//有参注入
        a.add();
        FQLOVE a1=(FQLOVE) factory.getBean("fq1");//set注入
        a1.add();
        FQLOVE a2=(FQLOVE) factory.getBean("fq2");//p命名空间
        a2.add();
    }

    @Test
    public void fq2(){
        //注入外部bean对象
        BeanFactory factory=new ClassPathXmlApplicationContext("wql2.xml");
        FQLOVE fqlove=(FQLOVE) factory.getBean("fq1");
        System.out.println(fqlove.wql);

        //注入内部bean对象
        BeanFactory factory1 =new ClassPathXmlApplicationContext("wql2.xml");
        FQLOVE fqlove1=(FQLOVE) factory1.getBean("fq2");
        System.out.print(fqlove1.wql);

        //级联赋值
        BeanFactory factory2=new ClassPathXmlApplicationContext("wql2.xml");
        FQLOVE fqlove2=(FQLOVE) factory2.getBean("fq3");
        System.out.print(fqlove2.wql);
    }

    @Test
    public  void fq3(){
        //注入数组，Array，set
        BeanFactory factory2=new ClassPathXmlApplicationContext("wql3.xml");
        WQLcollection fqlove2=(WQLcollection) factory2.getBean("fq");
        fqlove2.show();

        System.out.print("\n");
        //注入Map
        BeanFactory factory3=new ClassPathXmlApplicationContext("wql3.xml");
        WQLcollection fqlove3=(WQLcollection) factory3.getBean("fq1");
        fqlove3.show2();
    }

    @Test
    public  void fq4(){
        BeanFactory factory2=new ClassPathXmlApplicationContext("wql4.xml");
        wqlduix fqlove2=(wqlduix) factory2.getBean("fq");
        fqlove2.show();
        wqlduix fqlove3=(wqlduix) factory2.getBean("fq100");
        fqlove3.show();
    }

    @Test
    public  void fq5(){
        BeanFactory factory=new ClassPathXmlApplicationContext("wql5.xml");
        FQLOVE facewql1=(FQLOVE) factory.getBean("fq");
        facewql1.add();

    }

    @Test
    public  void fq6(){
        BeanFactory factory=new ClassPathXmlApplicationContext("wql6.xml");
        //这两是单例创建出来的
        FQLOVE a=(FQLOVE) factory.getBean("fq");
        FQLOVE b=(FQLOVE) factory.getBean("fq");
        //看是否相等
        System.out.println(a==b);
        //多例创建出来的
        FQLOVE a1=(FQLOVE) factory.getBean("fq1");
        FQLOVE b1=(FQLOVE) factory.getBean("fq1");
        System.out.println(a1==b1);
    }

    @Test
    public void fq7(){
        BeanFactory factory=new ClassPathXmlApplicationContext("wql7.xml");
        fuleijicwql a=(fuleijicwql)factory.getBean("wql1");//继承类属性
        a.f();
    }

    @Test
    public void fq8(){
        BeanFactory factory=new ClassPathXmlApplicationContext("wql8.xml");
        FQLOVE a = (FQLOVE) factory.getBean("wql");//自动装配
        System.out.print(a.wql);
    }

    @Test
    public  void fq9() {
        BeanFactory factory = new ClassPathXmlApplicationContext("wql9.xml");
        zhujewql2 a = (zhujewql2) factory.getBean("a");
        a.i();
    }

    @Test
    public void fq10() {
        BeanFactory factory = new ClassPathXmlApplicationContext("wql10.xml");
        proxywql a = (proxywql) factory.getBean("wql10");
        a.wql();

    }

    @Test
    public void f(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("wql11.xml");
       lifecyclewql a= (lifecyclewql)applicationContext.getBean("fq");
       System.out.println("6，获取bean对象");
        System.out.print(a);
        applicationContext.close();//close在接口类中没有，要么直接本类，要么强转


    }
    }
