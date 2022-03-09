package wql;

import bean.UserAdress;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

public class main_ {
    public static void main(String[] args) throws IOException {

        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("cunsumer.xml");

        OrderAdress orderAdress = (OrderAdress) applicationContext.getBean(OrderAdress.class);

        orderAdress.init();

        System.in.read();
    }
}
