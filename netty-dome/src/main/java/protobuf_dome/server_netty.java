package protobuf_dome;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

public class server_netty {
    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup bossgroup = new NioEventLoopGroup();

        EventLoopGroup workergroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();

       try {
           System.out.println("服务器端启动！！");
           serverBootstrap.group(bossgroup,workergroup)
                   .channel(NioServerSocketChannel.class)
                   .option(ChannelOption.SO_BACKLOG, 128)
                   .childOption(ChannelOption.SO_KEEPALIVE, true)
                   .childHandler(
                           new ChannelInitializer<SocketChannel>() {
                               @Override
                               protected void initChannel(SocketChannel socketChannel) throws Exception {
                                   //添加自定义处理器
                                   socketChannel.pipeline().addLast(new handler_netty());
                                   //添加Protobuf解码器，参数需要指定对那种对象进行解码
                                   socketChannel.pipeline().addLast("decode",new ProtobufDecoder(wql.wql_fq.getDefaultInstance()));
                               }
                           });

           ChannelFuture channelFuture = serverBootstrap.bind(9999).sync();

           channelFuture.addListener(new ChannelFutureListener() {
               public void operationComplete(ChannelFuture channelFuture) throws Exception {
                   Boolean A = channelFuture.isSuccess();
                   if(A){
                       System.out.println("端口绑定成功！！");
                    }else {
                       System.out.println("端口绑定失败！！");
                   }
               }
           });

           channelFuture.channel().closeFuture().sync();
       }finally {
           bossgroup.shutdownGracefully();
           workergroup.shutdownGracefully();
       }
    }
}
