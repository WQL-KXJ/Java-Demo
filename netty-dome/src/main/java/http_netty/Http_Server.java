package http_netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Http_Server {

    public static void main(String[] args) {

        //定义BossGroup
        EventLoopGroup BossGroup = new NioEventLoopGroup();

        //定义WorkerGroup
        EventLoopGroup WorkerGroup = new NioEventLoopGroup();

        try {
            //定义服务器启动对象
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            //配置参数
            serverBootstrap.group(BossGroup,WorkerGroup)//指定BossGroup和WorkerGroup两组线程组
                           .channel(NioServerSocketChannel.class)//指定channel的实体类对象，在处理中使用那种Channel
                           .childHandler(new HttpSercerInitializer());//指定处理器类，我们不使用匿名类，使用外部配置

            //绑定端口
            ChannelFuture sync = serverBootstrap.bind("127.0.0.1", 9999).sync();

            System.out.println("Http服务端启动！！！");
            //对关闭通道进行监听
            ChannelFuture sync1 = sync.channel().closeFuture().sync();

            //在Future关闭通道中添加监听
            sync1.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    boolean a = channelFuture.isSuccess();
                    //判断端口是否绑定成功
                    if(a){
                        System.out.println("通道关闭！！！");
                    }else {
                        System.out.println("通道正常！！！");
                    }
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //关闭BossGroup和WorkerGroup
            BossGroup.shutdownGracefully();
            WorkerGroup.shutdownGracefully();
        }

    }
}
