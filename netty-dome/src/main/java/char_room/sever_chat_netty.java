package char_room;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class sever_chat_netty {

    public static void main(String[] args) throws InterruptedException {

    //创建BoosEventLoopGroup和WorkerEventLoopGroup两个池对象
        EventLoopGroup BoosEventLoopGroup = new NioEventLoopGroup(1);//指定线程池中的线程个数
        EventLoopGroup WorkerEventLoopGroup = new NioEventLoopGroup();//默认线程池中线程个数是CPU核数*2

        //服务对象
        ServerBootstrap bootstrap = new ServerBootstrap();

        //配置参数
        try {


        bootstrap.group(BoosEventLoopGroup,WorkerEventLoopGroup)
                .childOption(ChannelOption.SO_BACKLOG,128)
                .option(ChannelOption.SO_KEEPALIVE,true)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {

                        //获取pipeline
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        //向pipeline中加入解码器
                        pipeline.addLast("decode",new StringDecoder());
                        //向pipeline中加入编码器
                        pipeline.addLast("encode",new StringEncoder());
                        //加入业务处理Handler
                        pipeline.addLast(new server_handler_chat());

                    }
                });

        //配置端口,
        ChannelFuture future = bootstrap.bind("127.0.0.1", 9999).sync();

        future.channel().closeFuture().sync();
        }finally {
            BoosEventLoopGroup.shutdownGracefully();
            WorkerEventLoopGroup.shutdownGracefully();
        }
    }

}
