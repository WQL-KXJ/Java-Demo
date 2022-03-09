package dead_queue;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class dead_queue_util {
    public Connection dead_queue_getConnection() throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHandshakeTimeout(9999999);
        //设置参数
        factory.setHost("192.168.68.133");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("fq_wql");
        factory.setPassword("123");

        //创建连接
        Connection connection = factory.newConnection();

        return connection;

    }
}
