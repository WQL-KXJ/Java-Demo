import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIO_SocketChannel {

    public static void main(String[] args) throws IOException {

        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();

        //设置非阻塞
        socketChannel.configureBlocking(false);

        //提高服务器端的IP和端口
        InetSocketAddress inetSocketAddress =new InetSocketAddress("127.0.0.1",6666);


        //连接服务器
        if(!socketChannel.connect(inetSocketAddress)){

            while(!socketChannel.finishConnect()){

                System.out.println("连接等待，客户端不会堵塞！");
            }
        }

        String str = "袁爷爷一路走后！！";
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());

        //发送数据，将ByteBuffer的数据写入channel
        socketChannel.write(byteBuffer);


    }
}
