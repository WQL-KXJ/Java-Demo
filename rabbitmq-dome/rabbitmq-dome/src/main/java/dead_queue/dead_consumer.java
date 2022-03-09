package dead_queue;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class dead_consumer {
    //消费死信队列队列
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接对象
        Connection connection = new dead_queue_util().dead_queue_getConnection();

        //获取channel逻辑逻辑
        Channel channel = connection.createChannel();

        //成功回调
        DeliverCallback deliverCallback = (ConsumerTag, Message) -> {
            //打印消息
            System.out.println("消费死信队列：" + new String(Message.getBody(), "UTF-8"));
        };

        //失败回调
        CancelCallback cancelCallback = (ConsumerTag) -> {

        };
        //消费普通队列
        channel.basicConsume("dead_queue", false, deliverCallback, cancelCallback);
    }
}
