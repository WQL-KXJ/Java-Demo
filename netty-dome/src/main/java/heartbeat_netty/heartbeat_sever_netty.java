package heartbeat_netty;

import dome1.handler_netty;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class heartbeat_sever_netty {

    public static void main(String[] args) {

        //事件循环组
        EventLoopGroup bossgroup = new NioEventLoopGroup();
        EventLoopGroup workergroup = new NioEventLoopGroup();

        try {

        //创建服务器的启动对象，配置参数
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossgroup,workergroup)//设置两个线程组
                .channel(NioServerSocketChannel.class)//使用NioSocketChannel作为服务器的通道实现
                .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列等待连接的个数
                .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保持活动的连接状态
                .handler(new LoggingHandler(LogLevel.INFO))//在Bossgroup添加一个日志处理器
                .childHandler(
                        new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {

                                ChannelPipeline pipeline = socketChannel.pipeline();
                                /*
                                * 加入一个Netty提供的IdleStateHandler
                                * 说明：
                                * IdleStateHandler是Netty提供的处理空间状态的处理器
                                * 当IdleStateHandler触发后，就会传递给管道的下一个handler去处理通过调用下一个handler的userEventTiggered，在该方法中
                                * 去处理IdleStateHandler的读空闲或者写空闲，读写空闲
                                * 参数：
                                * 1，readerldleTime：表示多长时间没有读，就会发送一个心跳检测包检测是否连接
                                * 2，writerldleTime：表示多长时间没有写，就会发送一个心跳检测包检测是否连接
                                * 3，alldleTiime：表示多长时间没有读写，就会发送一个心跳检测包检测是否连接
                                *  */
                                pipeline.addLast(new IdleStateHandler(3,5,7, TimeUnit.SECONDS));

                                //加入一个对空闲检测进一步处理的Handler(自定义)
                                pipeline.addLast(new hearbeat_handler());
                            }
                        });
            ChannelFuture channelFuture = serverBootstrap.bind("127.0.0.1", 9999).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossgroup.shutdownGracefully();
            workergroup.shutdownGracefully();
        }
    }
}
