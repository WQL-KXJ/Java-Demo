package message_response;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class message_response_util {
    public Connection message_response_getConnection() throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置参数
        factory.setHost("192.168.68.133");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("love");
        factory.setPassword("123");

        //创建连接
        Connection connection = factory.newConnection();

        return connection;

    }
}
