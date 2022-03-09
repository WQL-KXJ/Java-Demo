package char_room;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;

public class server_handler_chat extends SimpleChannelInboundHandler<String> {

    //定义一个channel组，管理所有的channel,channelGroup底层是一个set集合，用于存储channel
    //GlobalEventExecutor.instance 是全局的事件执行取，是一个单例
   private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

   //创建一个时间对象
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //handlerAdded表示连接建立就执行的方法，是最开始就执行的方法
    //将当前的channel加入到channelGroup
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //获取当前的channel
        Channel channel = ctx.channel();
        //将用户加入聊天进行显示
        channelGroup.writeAndFlush("[用户] "+channel.remoteAddress()+"加入聊天！");
        //将当前的channel加入到channelGroup中
        channelGroup.add(channel);
    }

    //表示channel处于活动状态，提示xx用户上线
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("[用户] "+ctx.channel().remoteAddress()+"上线！");

    }

    //表示channel处于非活动状态，提示xx用户离线
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[用户] "+ctx.channel().remoteAddress()+"离线！");
    }

    //连接断开，将xx客户离开信息推送给当前在线用户
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[用户]"+channel.remoteAddress()+"离开了！");
        //handlerRemoved 方法一旦执行完成 ，会自动把channelGroup的channel移除，不需要手动移除
    }

    //读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String o) throws Exception {

        //获取当前channel
        Channel channel = channelHandlerContext.channel();
        //遍历channelGroup，根据不同情况，回送不同信息
        channelGroup.forEach(a -> {
            if(channel != a) {//不是当前的channel，直接转发
            a.writeAndFlush("[客户]"+channel.remoteAddress()+"："+o+"\n");
            }else {
                a.writeAndFlush("我发送信息："+o+"\n");
            }
        });
    }

    //异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
