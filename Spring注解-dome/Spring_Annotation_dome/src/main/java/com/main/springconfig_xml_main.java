package com.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springconfig_xml_main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

        Object bean = context.getBean("config_xml");

        System.out.println(bean);

    }

}
