package dome1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class server_netty {
    public static void main(String[] args) throws InterruptedException {

        //创建BossGroup和WorkerGroup两个线程循环组
        //创建BossGroup只处理连接请求
        EventLoopGroup bossgroup = new NioEventLoopGroup();

        //创建WorkerGroup处理具体业务
        EventLoopGroup workergroup = new NioEventLoopGroup();

        //创建服务器的启动对象，配置参数
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        //使用链式编程来设置BootStrap服务器启动对象的参数配置
       try {
           System.out.println("服务器端启动！！");
           serverBootstrap.group(bossgroup,workergroup)//设置两个线程组
                   .channel(NioServerSocketChannel.class)//使用NioSocketChannel作为服务器的通道实现
                   .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列等待连接的个数
                   .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保持活动的连接状态
                   .childHandler(
                           //创建一个通道测试对象，匿名对象创建
                           new ChannelInitializer<SocketChannel>() {
                               //给pipeline设置处理器ChannelHandler
                               @Override
                               protected void initChannel(SocketChannel socketChannel) throws Exception {

                                   System.out.println("客户对应的SocketChannel："+socketChannel.hashCode());
                                   socketChannel.pipeline().addLast(new handler_netty());//添加自定义处理器
                               }
                           });//给WorkerGroup的EventLoop对应的管道设置处理器

           //服务器对象绑定端口并同步，生成一个ChannelFuture对象
           ChannelFuture channelFuture = serverBootstrap.bind(9999).sync();

           //绑定监听
           channelFuture.addListener(new ChannelFutureListener() {
               public void operationComplete(ChannelFuture channelFuture) throws Exception {
                  //监听绑定是否成功
                   Boolean A = channelFuture.isSuccess();
                   if(A){
                       System.out.println("端口绑定成功！！");
                    }else {
                       System.out.println("端口绑定失败！！");
                   }
               }
           });

           //对关闭通道进行监听
           channelFuture.channel().closeFuture().sync();
       }finally {
           bossgroup.shutdownGracefully();
           workergroup.shutdownGracefully();
       }
    }
}
