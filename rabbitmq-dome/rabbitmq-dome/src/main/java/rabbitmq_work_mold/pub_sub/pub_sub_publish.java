package rabbitmq_work_mold.pub_sub;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class pub_sub_publish {
    public static void main(String[] args) throws IOException, TimeoutException {

        //获取连接对象
        Connection connection = new pub_sub_util().pub_sub_getConnection();

        //获取channel逻辑逻辑
        Channel channel = connection.createChannel();

        /*创建一个Exchange交换机
         * 参数：
         * String exchange：交换机的名称
         * BuiltinExchangeType type：路由的类型，有四种Fanout,Driect,Topic,Headers，这里是枚举类型
         * boolean durable：是否持久化
         * boolean autoDelete：是否自动删除
         * boolean internal：内部使用，一般为false
         * Map<String, Object> arguments：参数
         * */
        String exchange_name = "Love_FQ";//交换机名称
        channel.exchangeDeclare(exchange_name, BuiltinExchangeType.FANOUT, true, false, false, null);

        //创建两个队列分别为queue1，queue2
        String queue1_name = "queue1"; //队列名称
        String queue2_name = "queue2"; //队列名称
        channel.queueDeclare(queue1_name, true, false, false, null);
        channel.queueDeclare(queue2_name, true, false, false, null);

        /*将队列和交换机进行绑定(之前的普通模式和工作队列模式使用的是默认交换机，不需要手动进行绑定，自定义交换机需要手动进行绑定)
         * 参数：
         * String queue：队列的名称
         * String exchange：路由的名称
         * String routingKey：指定routingKey，使用Fanout广播模式指定为""进行
         * Map<String, Object> arguments：参数(一般使用Headers模式会用到)
         * */
        channel.queueBind(queue1_name, exchange_name, "", null);
        channel.queueBind(queue2_name, exchange_name, "", null);

        //创建生产者发送消息
        String message = "WQL发送了一个级别为Wain的消息！！";
        for(int a=1;a<20;a++) {
            channel.basicPublish(exchange_name, "", null, message.getBytes());
        }
        //关闭连接
        channel.close();
        connection.close();
    }
}
