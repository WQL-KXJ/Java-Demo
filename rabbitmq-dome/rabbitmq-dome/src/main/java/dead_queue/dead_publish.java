package dead_queue;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;

public class dead_publish {
    //定义普通交换机和普通队列的名称
    static String common_exchange = "com_exchange";
    static String common_queue = "com_queue";
    //定义死信交换机和死信队列的名称
    static String dead_exchange = "dead_exchange";
    static String dead_queue = "dead_queue";

    public static void main(String[] args) throws IOException, TimeoutException {

        //获取连接对象
        Connection connection = new dead_queue_util().dead_queue_getConnection();

        //获取channel逻辑逻辑
        Channel channel = connection.createChannel();

        //创建死信队列和死信交换机()
        channel.exchangeDeclare(dead_exchange, BuiltinExchangeType.DIRECT, true, false, false, null);
        channel.queueDeclare(dead_queue, true, false, false, null);

        //创建普通交换机和普通队列
        channel.exchangeDeclare(common_exchange, BuiltinExchangeType.DIRECT, true, false, false, null);

        //通过Map加入参数
        ConcurrentHashMap<String, Object> arguments = new ConcurrentHashMap();
        //设置死信交换机
        arguments.put("x-dead-letter-exchange", dead_exchange);
        //设置死信Routing Key(使死信交换机直接将消息通过routingkey路由死信队列)
        arguments.put("x-dead-letter-routing-key", "deadqueue");
        //方便测试设置消息的TTL（在发送时设置更好）
        //arguments.put("x-message-ttl",10000);

        //创建普通队列，并通过arguments参数绑定死信交换机
        channel.queueDeclare(common_queue, true, false, false, arguments);

        //绑定死信队列和死信交换机
        channel.queueBind(dead_queue, dead_exchange, "deadqueue");

        //绑定普通队列和普通交换机
        channel.queueBind(common_queue, common_exchange, "comqueue");

        //循环发送20条消息并设置TTL时间为10000
        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder().expiration("1000").build();

        for (int a = 1; a <= 20; a++) {
            String message = "mes = " + a;
            channel.basicPublish(common_exchange, "comqueue", basicProperties, message.getBytes());
        }
        //关闭连接
//        channel.close();
//        connection.close();
    }
}
