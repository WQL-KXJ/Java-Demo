import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIO_ServerSocketChannel {
    public static void main(String[] args) throws IOException {

        //创建ServerSocketChannel -> ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //得到一个Selector对象
        Selector selector = Selector.open();

        //绑定端口6666，在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",6666));

        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        //把serverSocketChannel注册到selector关心事件为连接事件OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端连接
        while(true){

            //等待一秒，如果没有事件发生，就continue（轮询的监听）
            if(selector.select(1000)==0){
                System.out.println("服务器等待1秒，无连接！");
                //当selector没有事件产生跳出本次循环
                continue;
            }

            //如果selector.select大于零，获取相关的selectionkey集合
            //1,返回大于零表示已经获取到产生事件的集合
            //2,selector.selectedKeys获取发生事件的集合，注：selector.Keys是注册到Selector的所有集合，我们之需要发生事件的集合
            //3,通过SelectionKey反向获取通道
            Set<SelectionKey> selectionKeys =selector.selectedKeys();

            //set<SelectionKey>使用迭代器
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            //遍历迭代器
            while(iterator.hasNext()){

                //得到SelectionKey集合元素
                SelectionKey selectionKey = iterator.next();

                //对事件分别处理，因为事件有连接事件，读事件，写事件通过if进行分别处理
                //如果发生的是连接事件OP_ACCEPT,有新的客户端连接
                if(selectionKey.isAcceptable()){

                    //新的客户端连接，就产生一个新的SocketChannel分配给客户端
                    SocketChannel socketChannel= serverSocketChannel.accept();

                    //设置channel为非阻塞
                    socketChannel.configureBlocking(false);

                    //将新产生的socketChannel注册到Selector上,同时为channel关联一个Buffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));

                    System.out.println("客户端连接成功："+socketChannel.hashCode());
                }

                //如果发生的是读取事件,就读取数据
                if(selectionKey.isReadable()){
                    //反向获取channel
                    SocketChannel channel = (SocketChannel)selectionKey.channel();

                    //获取到channel关联的buffer
                    ByteBuffer attachment = (ByteBuffer)selectionKey.attachment();
                    channel.read(attachment);
                    System.out.println("客户端发送数据："+ new String(attachment.array()));


                }

                //结束后从集合中移动selectionKey，防止重复操作
                iterator.remove();
            }

        }










    }
}
