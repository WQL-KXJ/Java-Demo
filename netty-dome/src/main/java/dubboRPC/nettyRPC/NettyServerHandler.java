package dubboRPC.nettyRPC;

import dubboRPC.provider.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //获取客户端的消息，并调用服务
        System.out.println("msg:"+msg);
        //客户端在调用服务器的api时，定一个协议(每一次发信息时都必须以字符串"#WQL_FQ#"开头)
        if (msg.toString().startsWith("#WQL_FQ#")) {
            String a = new HelloServiceImpl().hello(msg.toString().substring(msg.toString().lastIndexOf("#")+1));
            ctx.writeAndFlush(a);
        }

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

            ctx.close();
    }
}
