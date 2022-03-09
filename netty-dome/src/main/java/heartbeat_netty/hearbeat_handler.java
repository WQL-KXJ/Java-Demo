package heartbeat_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

public class hearbeat_handler  extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if(evt instanceof IdleStateEvent){
            //将evt向下转型IdleStateEvent
            IdleStateEvent event =(IdleStateEvent) evt;
            String wql=null;
            switch (event.state()){
                case READER_IDLE:
                     wql="发生了读空闲";
                      break;
                case WRITER_IDLE:
                    wql="发生了写空闲";
                    break;
                case ALL_IDLE:
                    wql="发生了读写空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress()+"---超时时间---\n"+wql);
            //如果发生空闲我们就关闭通道
            ctx.channel().close();
        }
    }
}
