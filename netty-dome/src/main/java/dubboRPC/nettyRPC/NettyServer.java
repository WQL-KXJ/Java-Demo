package dubboRPC.nettyRPC;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetAddress;

public class NettyServer {

    public static  void server(String host,int port){

        startServer0(host,port);

    }



    //编写一个方法，完成对NettyServer的初始化和启动
    private  static void startServer0(String host,int port){

        EventLoopGroup BoosGroup = new NioEventLoopGroup(1);
        EventLoopGroup WorkGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap =new ServerBootstrap();
        try{

            bootstrap.group(BoosGroup,WorkGroup)
                     .channel(NioServerSocketChannel.class)
                     .childHandler(new ChannelInitializer<SocketChannel>() {

                         @Override
                         protected void initChannel(SocketChannel socketChannel) throws Exception {

                             //获取channel中的pipline
                           ChannelPipeline  pipeline = socketChannel.pipeline();

                           //在channelhandler中放入编解码器
                             pipeline.addLast(new StringEncoder());
                             pipeline.addLast(new StringDecoder());
                             //自定义handler处理器
                             pipeline.addLast(new NettyServerHandler());
                         }
                     });

                //绑定IP和端口
            ChannelFuture sync = bootstrap.bind(host, port).sync();
            System.out.println("服务提供端启动！！"+host+"/n"+port);
            sync.channel().close().sync();


        }catch (Exception e){


        }finally {


        }

    }

}
