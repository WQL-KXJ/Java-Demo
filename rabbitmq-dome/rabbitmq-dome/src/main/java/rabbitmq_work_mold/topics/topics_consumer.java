package rabbitmq_work_mold.topics;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class topics_consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接对象
        Connection connection = new topics_util().topics_getConnection();

        //获取channel逻辑逻辑
        Channel channel = connection.createChannel();

        //Consumer1的回调
        Consumer consumercallback1 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("订阅" + envelope.getExchange() + "的topic_queue1队列" + "\n" + "publish消息：" + new String(body));
            }
        };
        //Consumer2的回调
        Consumer consumercallback2 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("订阅" + envelope.getExchange() + "的topic_queue2队列" + "\n" + "publish消息：" + new String(body));
            }
        };

        //创建两个Consumer分别绑定queue1队列和queue2队列
        channel.basicConsume("topic_queue1", true, consumercallback1);
        channel.basicConsume("topic_queue2", true, consumercallback2);

        //关闭连接
//        channel.close();
//        connection.close();
    }
}
