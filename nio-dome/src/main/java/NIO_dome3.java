import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO_dome3 {
    public static void main(String[] args) throws IOException {

        //1,将要拷贝文件的读入
        FileInputStream fileInputStream = new FileInputStream("wql.txt");

        //通过FileInputStream获取Channel
        FileChannel fileChannel = fileInputStream.getChannel();

        //创建Buffer缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将Channel的数据read到Buffer中
        fileChannel.read(byteBuffer);

        //2,将要拷贝文件写出，创建FileoutputStream
        FileOutputStream fileOutputStream = new FileOutputStream("fq.txt");

        //缓冲区反转
        byteBuffer.flip();

        //通过fileOutputStream创建Channel
        FileChannel fileChannel1=fileOutputStream.getChannel();

        //将缓冲区的数据writer写入Channel
        fileChannel1.write(byteBuffer);
    }
}
