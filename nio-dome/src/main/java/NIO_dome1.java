import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


//使用ByteBuffer(字节缓冲区)和FileChannel(通道)，将自定义字符写入到wql.txt文件中

public class NIO_dome1 {
    public static void main(String[] args) throws IOException {

        String content = "WQL 6666";
        //获取一个文件输出流
        FileOutputStream Stream =new FileOutputStream("wql.txt");

        //通过流获取FileChannel通道
        FileChannel fileChannel = Stream.getChannel();

        //创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //往Buffer中存字符
        byteBuffer.put(content.getBytes());

        //反转缓冲区
        byteBuffer.flip();

        //将缓冲区的数据写入通道
        fileChannel.write(byteBuffer);




    }
}
