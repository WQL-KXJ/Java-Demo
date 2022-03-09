package message_response;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq_work_mold.pub_sub.pub_sub_util;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class message_respoonse_publish {
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接对象
        Connection connection = new message_response_util().message_response_getConnection();

        //获取channel逻辑逻辑
        Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare("message_response_exchange", BuiltinExchangeType.FANOUT, true, false, false, null);

        //创建队列
        channel.queueDeclare("message_wql", true, false, false, null);

        //交换机和队列绑定
        channel.queueBind("message_wql", "message_response_exchange", "", null);

        //创建生产者发送消息
        String mess;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            mess = "WQL Love FQ：" + scanner.next();
            channel.basicPublish("message_response_exchange", "", null, mess.getBytes());
        }
        //关闭连接
//        channel.close();
//        connection.close();
    }
}
