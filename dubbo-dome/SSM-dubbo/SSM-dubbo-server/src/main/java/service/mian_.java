package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class mian_ {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext  ioc = new ClassPathXmlApplicationContext("provider.xml");

        ioc.start();

        System.in.read();
    }


}
