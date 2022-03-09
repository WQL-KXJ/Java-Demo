package protobuf_dome;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class handlerclient_netty extends ChannelInboundHandlerAdapter {

    //当通道就绪就会触发该方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //获取Protobuf的对象实例
        //设置ID值为4，name值为晴天，并将对象返回
        wql.wql_fq build = wql.wql_fq.newBuilder().setId(4).setName("晴天").build();

        //将对象发送给服务器端
        ctx.writeAndFlush(build);
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("服务器发来的消息："+byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("服务器端的地址"+ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
