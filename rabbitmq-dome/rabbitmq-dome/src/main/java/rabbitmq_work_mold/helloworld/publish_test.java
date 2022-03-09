package rabbitmq_work_mold.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class publish_test {

    public static void main(String[] args) throws IOException, TimeoutException {

        //1，创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();

        //2，设置工厂连接的参数
        //连接主机IP
        connectionFactory.setHost("192.168.68.133");
        //端口号(RabbitMQ默认端口5672)
        connectionFactory.setPort(5672);
        //设置Virtual host虚拟机(默认为'/')
        connectionFactory.setVirtualHost("/");
        //连接rabbitmq的用户名(需要在rabbitmq中单独设置)
        connectionFactory.setUsername("admin");
        //连接rabbitmq的密码
        connectionFactory.setPassword("123");

        //3，通过工厂创建Connection连接
        Connection connection = connectionFactory.newConnection();

        //4，通过连接创建一个逻辑连接
        Channel channel = connection.createChannel();

        /*
         * 5，创建一个队列
         *参数：
         * String queue：队列名称
         * boolean durable：是否持久化，持久化之后mq重启它依然存在
         * boolean exclusive：1，是否独占占(只有一个消费者能监听) 2，Connection连接断开后是否删除该队列
         * boolean autoDelete：是否在没有consumer监听时，自动删除队列
         * Map<String, Object> arguments：其他参数信息
         * 注：队列名不能重复
         * */
        channel.queueDeclare("FQ_LOVE", true, false, false, null);

        //消息
        String message = "啦啦啦,RabbitMQ";
        /*
         *  6，生产者发送消息
         * 参数：
         * String exchange：交换机(不是使用的话默认为"")
         * String routingKey：路由key(通过它让队列和交换机绑定)，如果使用默认交换机它和队列名一样即可绑定
         * BasicProperties props：配置信息
         * byte[] body：具体消息
         * */
        channel.basicPublish("", "FQ_LOVE", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());

        //7，关闭资源
        channel.close();
        connection.close();
    }
}
