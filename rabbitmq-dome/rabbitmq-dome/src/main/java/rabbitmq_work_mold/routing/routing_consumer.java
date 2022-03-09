package rabbitmq_work_mold.routing;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class routing_consumer {
    public static void main(String[] args) throws IOException, TimeoutException {

        //获取连接对象
        Connection connection = new routing_util().routing_getConnection();

        //获取channel逻辑逻辑
        Channel channel = connection.createChannel();

        //回调对象
        Consumer consumer1 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                System.out.println("绑定队列queue_fq RoutingKey：FQ -->" + new String(body));
            }
        };
        Consumer consumer2 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("绑定队列queue_wql RoutingKey：WQL-->" + new String(body));
            }
        };

        //创建两个消费者分别订阅queue_fq和queue_wql队列
        channel.basicConsume("queue_wql", true, consumer2);
        channel.basicConsume("queue_fq", true, consumer1);

        //关闭连接
        channel.close();
        connection.close();
    }
}
