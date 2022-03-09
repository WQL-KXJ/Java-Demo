package protobuf_dome;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

public class client_netty {
    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup eventExecutors = new NioEventLoopGroup();


        Bootstrap bootstrap = new Bootstrap();
   try{

        bootstrap.group(eventExecutors)
                 .channel(NioSocketChannel.class)
                 .handler(new ChannelInitializer<SocketChannel>() {
                     protected void initChannel(SocketChannel socketChannel) throws Exception {
                         //加入handler处理器
                         socketChannel.pipeline().addLast(new handlerclient_netty());
                        //加入Protobuf编码器
                         socketChannel.pipeline().addLast("encode",new ProtobufEncoder());
                     }
                 });


        ChannelFuture sync = bootstrap.connect("127.0.0.1", 9999).sync();


        sync.channel().closeFuture().sync();
   }finally {
       eventExecutors.shutdownGracefully();
   }
    }
}
