package dubboRPC.consumer;

import dubboRPC.nettyRPC.NettyClient;
import dubboRPC.publicinterface.HelloService;

public class ClientBootstrap {

    //定义协议头
    public  static  final String providername = "hello#WQL_FQ#";

    public static void main(String[] args) {

        //创建一个消费者
        NettyClient consumer = new NettyClient();

        //创建篇代理对象
      HelloService service= (HelloService) consumer.getBean(HelloService.class,providername);

      //通过代理对象调用服务提供者的方法(服务)
        String res = service.hello("自定义dubbo rpc");
        System.out.println("调用结果："+res);

    }

}
