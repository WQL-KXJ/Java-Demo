package rabbitmq_work_mold.topics;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class topics_publish {
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接对象
        Connection connection = new topics_util().topics_getConnection();

        //获取channel逻辑逻辑
        Channel channel = connection.createChannel();

        //声明Exchange交换机，路由策略为Topics
        String exchange_name = "topics_exchange";
        channel.exchangeDeclare("topics_exchange", BuiltinExchangeType.TOPIC, true, false, false, null);

        //创建两个队列
        String topic_queue = "topic_queue1";
        String topic_queue1 = "topic_queue2";
        channel.queueDeclare(topic_queue, true, false, false, null);
        channel.queueDeclare(topic_queue1, true, false, false, null);

        //交换机和队列绑定
        channel.queueBind(topic_queue, exchange_name, "topic.#", null);
        channel.queueBind(topic_queue1, exchange_name, "topic.*.java", null);

        //生产者发送消息
        String message = "topic模式：匹配top.#";
        channel.basicPublish(exchange_name, "topic.www.java.we", null, message.getBytes());

        //关闭连接
//        channel.close();
//        connection.close();
    }
}
