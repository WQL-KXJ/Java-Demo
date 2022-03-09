package rabbitmq_work_mold.helloworld;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class comsumer_test {
    public static void main(String[] args) throws IOException, TimeoutException {

        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置参数
        factory.setHost("192.168.68.133");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("admin");
        factory.setPassword("123");

        //创建连接
        Connection connection = factory.newConnection();

        //创建Channel
        final Channel channel = connection.createChannel();

        //声明一个队列(消费者其实可以创建队列，使用和生产者一样的队列，如果队列创建将不再创建)
        channel.queueDeclare("FQ_LOVE", false, false, false, null);


        //定义回调对象，需要传入chanel对象
        Consumer consumer = new DefaultConsumer(channel) {
            /*重写handleDelivery回调方法，当接收到消息会自动执行该方法
             * String consumerTag：消息的标识
             * Envelope envelope：获取交换机，路由key等信息
             * AMQP.BasicProperties properties：配置信息
             * byte[] body：真实的数据
             * */
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                System.out.println("publish发送：" + new String(body));

            }

        };
        /*消费消息
         * 参数：
         *String var1：消费的队列名称
         *boolean var2：是否自动消息确认
         *Consumer var3：回调对象
         * */
        channel.basicConsume("FQ_LOVE", true, consumer);

        //关闭连接
        // channel.close();
        //connection.close();


    }
}
