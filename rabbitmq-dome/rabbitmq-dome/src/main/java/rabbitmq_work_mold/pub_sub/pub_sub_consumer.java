package rabbitmq_work_mold.pub_sub;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class pub_sub_consumer {
    public static void main(String[] args) throws IOException, TimeoutException {

        //获取连接对象
        Connection connection = new pub_sub_util().pub_sub_getConnection();

        //获取channel逻辑逻辑
        Channel channel = connection.createChannel();

        //Consumer1的回调
        Consumer consumercallback1 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("订阅" + envelope.getExchange() + "的queue1队列" + "\n" + "publish消息：" + new String(body));
            }
        };
        //Consumer2的回调
        Consumer consumercallback2 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("订阅" + envelope.getExchange() + "的queue2队列" + "\n" + "publish消息：" + new String(body));
            }
        };

        //创建两个Consumer分别绑定queue1队列和queue2队列
        channel.basicConsume("queue1", true, consumercallback1);
        channel.basicConsume("queue2", true, consumercallback2);

        //关闭连接
//        channel.close();
//        connection.close();


    }
}
