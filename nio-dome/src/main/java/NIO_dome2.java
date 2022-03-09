import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO_dome2 {

    public static void main(String[] args) throws IOException {

        //读取文件wql.txt
        FileInputStream fileInputStream = new FileInputStream(new File("wql.txt"));

        //获取Channel通道(数据也通过inputStream进入通道)
        FileChannel fileChannel = fileInputStream.getChannel();

        //创建Buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将通道的数据read到Buffer中
        fileChannel.read(byteBuffer);

        //反转Buffer
        byteBuffer.flip();

        //打印数据
        System.out.println(new String(byteBuffer.array()));

        fileChannel.close();
    }
}
