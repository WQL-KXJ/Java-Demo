package rabbitmq_work_mold.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class workqueue_publish {
    public static void main(String[] args) throws IOException, TimeoutException {

        //创建Util工具类对象
        workqueue_util workqueueUtil = new workqueue_util();
        Connection connection = workqueueUtil.getConnection();

        //创建channel逻辑连接对象
        Channel channel = connection.createChannel();

        //创建队列
        channel.queueDeclare("FQ", false, false, false, null);

        //消息实体
        String message = "WorkQueueMold & RabbitMQ";

        //生产发送消息
        for (int a = 1; a < 10; a++) {
            channel.basicPublish("", "FQ", null, new String(message + " " + a).getBytes());
        }
        //7，关闭资源
//        channel.close();
//        connection.close();
    }
}
