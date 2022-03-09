import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class NIO_dome4 {

    public static void main(String[] args) throws IOException {

        //创建输入流和输出流
        FileInputStream fileInputStream = new FileInputStream("FQ.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("love.jpg");

        //通过输入流和输出流创建Channel
        FileChannel fileChannel = fileInputStream.getChannel();
        FileChannel fileChannel1 = fileOutputStream.getChannel();

        //将目标通道的数据复制到当前通道
        //必须设置position位置和长度
        fileChannel1.transferFrom(fileChannel,0,fileChannel.size());

        //关闭通道
        fileChannel.close();
        fileChannel1.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}
