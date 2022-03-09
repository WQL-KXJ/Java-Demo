package protobuf_dome;


import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;


public class handler_netty extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {

        //读取从客户端发送的数据wql.wql_fq
        wql.wql_fq build = (wql.wql_fq)msg;

        //读取客户端发送的数据
        System.out.println("ID："+build.getId()+"name："+build.getName());

    }



    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        ctx.writeAndFlush(Unpooled.copiedBuffer("hello，wql你好", CharsetUtil.UTF_8));
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
