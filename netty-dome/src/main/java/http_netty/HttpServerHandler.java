package http_netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/*
SimpleChannelInboundHandler是ChannelInboundHandlerAdapter的子类
HttpObject客户端和服务器相互通讯的数据被封装成HttpObject
*/
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        //判断httpObject是不是Httprequest请求
        if(httpObject instanceof HttpRequest){
            System.out.println("msg 类型："+httpObject.getClass());
            System.out.println("客户端地址："+channelHandlerContext.channel().remoteAddress());
        }

        //回复消息给浏览器 (Http协议)
        ByteBuf content = Unpooled.copiedBuffer("hello，我是WQL！", CharsetUtil.UTF_8);
        //构造一个Http的相应，即httpResponse，参数：协议，状态码，Buffer
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE,"wql/fq");
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());

        //将构建好的response返回
        channelHandlerContext.writeAndFlush(defaultFullHttpResponse);

    }
}
