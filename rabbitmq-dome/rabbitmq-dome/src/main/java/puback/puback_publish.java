package puback;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.Connection;
import message_response.message_response_util;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeoutException;

public class puback_publish {
    //获取连接对象
    Connection connection = new message_response_util().message_response_getConnection();

    //获取channel逻辑逻辑
    Channel channel = connection.createChannel();

    public puback_publish() throws IOException, TimeoutException {
    }

    //单个确认发布
    public String single_upback() throws IOException, InterruptedException {

        //声明队列,没有自定义声明和绑定交换机，使用的就是默认交换机""，默认绑定Routing Key为队列的名称
        channel.queueDeclare("puback_queue", true, false, false, null);

        //开启消息确认
        channel.confirmSelect();

        //开始时间
        long begin = System.currentTimeMillis();

        //循环发送1000条消息并单个确认
        for (int a = 1; a <= 1000; a++) {

            //生产者发送消息
            channel.basicPublish("", "puback_queue", null, String.valueOf(a).getBytes());

            //单条消息确认
            boolean b = channel.waitForConfirms();
            if (b) {
                System.out.println("消息已发布确认！");
            }
        }
        //结束时间
        long end = System.currentTimeMillis();

        return "单个确认发布耗时(ms)：" + (end - begin);
    }

    //批量发布
    public String batch_upback() throws IOException, InterruptedException {

        //声明队列,没有自定义声明和绑定交换机，使用的就是默认交换机""，默认绑定Routing Key为队列的名称
        channel.queueDeclare("puback_queue", true, false, false, null);

        //开启消息确认
        channel.confirmSelect();

        //开始时间
        long begin = System.currentTimeMillis();

        //是否确认变量
        boolean b = false;

        //循环发送1000条消息,没得发送了100条时就确认一次
        for (int a = 1; a <= 1000; a++) {

            //生产者发送消息
            channel.basicPublish("", "puback_queue", null, String.valueOf(a).getBytes());

            //批量消息确认
            if (a % 1000 == 0) {
                b = channel.waitForConfirms();
            }
            if (b) {
                System.out.println("消息已发布确认！");
            }
        }
        //结束时间
        long end = System.currentTimeMillis();

        return "批量确认发布耗时(ms)：" + (end - begin);

    }

    //异步发布
    public String asynchronous_upback() throws IOException {

        //声明队列,没有自定义声明和绑定交换机，使用的就是默认交换机""，默认绑定Routing Key为队列的名称
        channel.queueDeclare("puback_queue", true, false, false, null);

        //开启消息确认
        channel.confirmSelect();

        //开始时间
        long begin = System.currentTimeMillis();


        //创建消息监听，异步监听那些消息是发布成功的，那些是发布失败的
        //消息成功发布的回调
        /*
         * 参数：
         *   1，deliveryTag：消息的唯一标识
         *   2，multiple：是否批量确认
         * */
        ConfirmCallback ackCallback = (deliveryTag, multiple) -> {
            System.out.println("消息发布确认成功！");

        };
        //消息发布失败的回调
        ConfirmCallback neckCallback = (deliveryTag, multiple) -> {


        };
        /*
         * 参数：两个参数类型是一样的
         *     1，监听哪些消息成功了
         *     2，监听那些消息失败了
         * */
        channel.addConfirmListener(ackCallback, neckCallback);

        //循环发送1000条消息,没得发送了100条时就确认一次
        for (int a = 1; a <= 1000; a++) {

            //生产者发送消息
            channel.basicPublish("", "puback_queue", null, String.valueOf(a).getBytes());

        }
        //结束时间
        long end = System.currentTimeMillis();

        return "异步确认发布耗时(ms)：" + (end - begin);
    }

    //异步处理为确认发布
    public String asynchronous_un_upback() throws IOException {

        //声明队列,没有自定义声明和绑定交换机，使用的就是默认交换机""，默认绑定Routing Key为队列的名称
        channel.queueDeclare("puback_queue", true, false, false, null);

        //开启消息确认
        channel.confirmSelect();

        //开始时间
        long begin = System.currentTimeMillis();

        //创建一个并发ConcurrentHashMap,，key为消息的为标识ID，值为消息的实体
        ConcurrentSkipListMap<Long, String> concurrentSkipListMap = new ConcurrentSkipListMap();

        ConfirmCallback ackCallback = (deliveryTag, multiple) -> {
            System.out.println("消息发布确认成功！");

            //2，删除concurrentmap已经确认的消息，剩下的就是未确认的消息
            ConcurrentNavigableMap map = concurrentSkipListMap.headMap(deliveryTag);

        };
        ConfirmCallback neckCallback = (deliveryTag, multiple) -> {
            //3，重新发送未确认的消息
            channel.basicPublish("", "puback_queue", null, concurrentSkipListMap.get(deliveryTag).getBytes());
        };

        channel.addConfirmListener(ackCallback, neckCallback);

        //循环发送1000条消息,没得发送了100条时就确认一次
        for (int a = 1; a <= 1000; a++) {
            //生产者发送消息
            channel.basicPublish("", "puback_queue", null, String.valueOf(a).getBytes());
            /*1，将发送的使用消息记录在map中
             * key：为消息ID唯一标识，通过channel获取
             * value：消息实体
             * */
            concurrentSkipListMap.put(channel.getNextPublishSeqNo(), String.valueOf(a));


        }
        //结束时间
        long end = System.currentTimeMillis();

        return "异步确认发布耗时(ms)：" + (end - begin);
    }
}
