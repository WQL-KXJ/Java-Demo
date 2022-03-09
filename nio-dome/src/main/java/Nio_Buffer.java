import java.nio.IntBuffer;
import java.nio.channels.Channel;

public class Nio_Buffer {
    public static void main(String[] args) {

        //定义一个Intbuffer，容量为5
        IntBuffer intBuffer = IntBuffer.allocate(5);

       //循环添加数据
        for (int i=0;i<intBuffer.limit();i++){
        intBuffer.put(i*2);//postition每一次向后移一位+1
        }
        //读写切换,把缓冲区进行翻转，把position设置为0，limit=当前的position，进行读取
        intBuffer.flip();

        //读取
        while (intBuffer.hasRemaining()){

        System.out.println(intBuffer.get());

        }

    }
}
