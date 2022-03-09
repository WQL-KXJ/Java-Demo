package rabbitmq_work_mold.routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class routing_publish {
    public static void main(String[] args) throws IOException, TimeoutException {

        //获取连接对象
        Connection connection = new routing_util().routing_getConnection();

        //获取channel逻辑逻辑
        Channel channel = connection.createChannel();

        //声明交换机，指定路由策略为Driect
        String exchange_name = "WQL_FQ";
        channel.exchangeDeclare("WQL_FQ", BuiltinExchangeType.DIRECT, true, false, false, null);

        //创建两个队列分别为queue_fq,queue_wql
        String Queue1 = "queue_wql";
        String Queue2 = "queue_fq";
        channel.queueDeclare(Queue1, true, false, false, null);
        channel.queueDeclare(Queue2, true, false, false, null);

        //将队列和交换机进行绑定
        channel.queueBind(Queue1, exchange_name, "WQL", null);//RoutingKey为WQL
        channel.queueBind(Queue2, exchange_name, "FQ", null);//RoutingKey为FQ

        //声明生产者发送消息
        String message = "Routing Key:WQL --> 路由模式";
        channel.basicPublish(exchange_name, "WQL", null, message.getBytes());

        //关闭连接
        channel.close();
        connection.close();
    }
}
