package dome1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class client_netty {
    public static void main(String[] args) throws InterruptedException {

        //客户端只需要一个线程循环组
        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        //创建客户端启动对象
        //注：服务器端用ServerBootStrap，客户端用BootStrap
        Bootstrap bootstrap = new Bootstrap();
   try{
        //设置参数
        bootstrap.group(eventExecutors)//设置线程组
                 .channel(NioSocketChannel.class)//设置客户端通道的实现类,反射
                 .handler(new ChannelInitializer<SocketChannel>() {
                     protected void initChannel(SocketChannel socketChannel) throws Exception {
                        //加入自己的处理器
                         socketChannel.pipeline().addLast(new handlerclient_netty());
                     }
                 });

        //启动客户端去连接服务器端
        ChannelFuture sync = bootstrap.connect("127.0.0.1", 9999).sync();

        //对关闭通道进行监听
        sync.channel().closeFuture().sync();
   }finally {
       eventExecutors.shutdownGracefully();
   }
    }
}
