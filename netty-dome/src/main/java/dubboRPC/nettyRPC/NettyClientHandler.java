package dubboRPC.nettyRPC;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private  ChannelHandlerContext context;//上下文
    private  String result;//返回结果
    private String pare;//客户端调用方法时，传入参数

    //与服务器的连接创建后，就会被调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context=ctx;
    }

    //收到服务器数据后，调用方法
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        result = msg.toString();
        notify();//唤醒等待线程

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    //被代理对象调用，发送数据给服务器 -->wait --> 等待被唤醒 -->返回结果
    @Override
    public synchronized Object call() throws Exception {
        context.writeAndFlush(pare);
        //进行wait
        wait();//等待channelRead方法获取到服务器结果后唤醒
        return result;//服务方返回的结果
    }

    //设置pare参数
    void setPare(String pare){
        this.pare=pare;
    }
}
