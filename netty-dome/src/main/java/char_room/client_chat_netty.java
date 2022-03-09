package char_room;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;


public class client_chat_netty {
    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup eventExecutors =new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        try {
        bootstrap.group(eventExecutors)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        //获取pipeline
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        //向pipeline中加入解码器
                        pipeline.addLast("decode",new StringDecoder());
                        //向pipeline中加入编码器
                        pipeline.addLast("encode",new StringEncoder());
                        //加入业务处理Handler
                        pipeline.addLast(new client_handler_chat());
                    }
                });

        ChannelFuture future = bootstrap.connect("127.0.0.1", 9999).sync();

        //得到一个channel
        Channel channel = future.channel();
        System.out.println("-----------------"+channel.localAddress()+"------------------");
        //客户端需要输入信息，创建一个扫描器
       Scanner scanner= new Scanner(System.in);
       while(scanner.hasNextLine()){
           String wql = scanner.nextLine();
           //通过channel 发送到服务器
           channel.writeAndFlush(wql+"\r\n");
       }
    }finally {
            eventExecutors.shutdownGracefully();
        }
        }

}
