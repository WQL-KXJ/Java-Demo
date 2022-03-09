package rabbitmq_work_mold.workqueue;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class workqueue_consumer2 {
    public static void main(String[] args) throws IOException, TimeoutException {

        //创建Util工具类对象
        workqueue_util workqueueUtil = new workqueue_util();
        Connection connection = workqueueUtil.getConnection();

        //创建channel逻辑连接对象
        Channel channel = connection.createChannel();

        //定义回调对象，需要传入chanel对象
        Consumer consumer = new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                System.out.println("publish发送：" + new String(body));
            }
        };

        //接收消息
        channel.basicConsume("FQ", true, consumer);

        //关闭连接
//        channel.close();
//        connection.close();

    }
}

