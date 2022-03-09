package dubboRPC.provider;

import dubboRPC.publicinterface.HelloService;

public class HelloServiceImpl implements HelloService {

    //当有消费者调用该方法时就返回一个结果
    @Override
    public String hello(String mes) {

        System.out.println("收到客户端消息："+mes);

        //根据mes返回不同的结果
        if(mes!=null){

            return "客户端我已收到消息:"+mes;

        }else {

            return "客户端我没有收到消息！！";
        }

    }
}
