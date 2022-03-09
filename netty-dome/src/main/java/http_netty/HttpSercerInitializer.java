package http_netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpSercerInitializer extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception {

        //提供Channel通道得到管道
        ChannelPipeline pipeline = socketChannel.pipeline();

        //加入一个netty提供的HttpServerCode(http服务的编解码器)
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());

        //加入自定义的Handler
        pipeline.addLast("MyTestHttpServerHandler",new HttpServerHandler());

        System.out.println("ll");

    }
}
