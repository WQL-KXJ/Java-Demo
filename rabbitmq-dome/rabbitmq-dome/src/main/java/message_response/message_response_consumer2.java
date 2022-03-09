package message_response;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class message_response_consumer2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接对象
        Connection connection = new message_response_util().message_response_getConnection();

        //获取channel逻辑逻辑
        final Channel channel = connection.createChannel();

        //回调对象
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("消息(consumer2)：" + new String(body));
                //手动消息应答
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicQos(2);
        //创建消费者
        channel.basicConsume("message_wql", consumer);

        //关闭连接
//        channel.close();
//        connection.close();

    }


}
