package dome1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/*
* 说明：
*     1，我们自定义一个Handler需要继承netty规定好的某个HandlerAdapter适配器
*     2，这时自定义一个Handler，在服务器中才叫Handler
* */
public class handler_netty extends ChannelInboundHandlerAdapter {

    /*
    * 读取实际数据(这里可以读取客户端发来的消息)
    *   1，ChannelHandlerContext是上下文对象，它包含有Channel通道和Pipeline管道
    *   2，Object msg就是客户端发送的数据，默认是Object
    * */
    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {

        //定义定时任务队列
        //将任务提交到定时任务scheduledTasQueue队列中
        ctx.channel().eventLoop().schedule(new Runnable() {
            public void run() {
            ctx.writeAndFlush(Unpooled.copiedBuffer("嘿嘿，WQL",CharsetUtil.UTF_8));
            System.out.println("gono!!");
            }
        },10, TimeUnit.SECONDS);


    }


    /*
    * 数据读取完毕，回送一个消息
    * */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //writeAndFlush方法是writer和flush两个方法的合并方法
        //将数据写入到缓存并刷新
        //对发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello，wql你好",CharsetUtil.UTF_8));

    }

    /*
     * 处理异常，一般发生异常关闭通道
     * */

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
