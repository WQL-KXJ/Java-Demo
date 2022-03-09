import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIO_Dome {

    public static void main(String[] args) throws IOException {

        //新建一个连接池
        ExecutorService executorService = Executors.newCachedThreadPool();

        //创建一个ServerSocket服务端
        ServerSocket serverSocket =new ServerSocket(9090);

        //while轮询获取连接
        while(true){

            System.out.println("等待连接！！");
            final Socket socket = serverSocket.accept();
            System.out.println("连接一个客户端！！");


            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        //线程调用handle方法
                        handle(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }}

        public  static void handle(Socket socket) throws IOException {
        //获取流
        InputStream inputStream =socket.getInputStream();
        //定义一个缓冲数组
        byte[] a =new byte[1024];
        //偏移量
        int len;
        //循环读取
        while(true){

            int b = inputStream.read(a);

            if(b!=-1){

            System.out.println(new String(a,0,b));

            }else{

                break;
            }


        }

        }






}
