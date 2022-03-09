package WebSocket_netty;

import char_room.server_handler_chat;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class websocket_server_netty {
    public static void main(String[] args) {
        //创建BoosEventLoopGroup和WorkerEventLoopGroup两个池对象
        EventLoopGroup BoosEventLoopGroup = new NioEventLoopGroup(1);//指定线程池中的线程个数
        EventLoopGroup WorkerEventLoopGroup = new NioEventLoopGroup();//默认线程池中线程个数是CPU核数*2

        //服务对象
        ServerBootstrap bootstrap = new ServerBootstrap();

        //配置参数
        try {


            bootstrap.group(BoosEventLoopGroup,WorkerEventLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //获取pipeline
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            //使用http的编码和解码器
                            pipeline.addLast(new HttpServerCodec());
                            //以块的方式写，添加ChunkedWrite处理器
                            pipeline.addLast(new ChunkedWriteHandler());
                            /*http数据在传输过程中是分段的，HttpObjectAggregator可以将多个段聚合
                            这就是为什么当浏览器发送大量数据时，就会发出多次http请求
                            */
                            pipeline.addLast(new HttpObjectAggregator(8192));
                            /*对应webSocket，它的数据是以帧（frame)的形式传递
                            *WebSocketFrame 下面有六个不同类型的帧的处理类
                            * 浏览器请求时 ws://localhost:9999/xxx 表示请求url
                            * WebSocketServerProtocolHandler核心功能是将http协议升级为WS协议，保持长连接
                            * */
                            pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));
                            //自定义Handler，处理业务逻辑
                            pipeline.addLast(new websocket_handler());
                        }
                    });

            //配置端口,
            ChannelFuture future = bootstrap.bind("127.0.0.1", 9999).sync();

            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            BoosEventLoopGroup.shutdownGracefully();
            WorkerEventLoopGroup.shutdownGracefully();
        }
    }

}

