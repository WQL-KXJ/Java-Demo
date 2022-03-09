package dubboRPC.provider;

import dubboRPC.nettyRPC.NettyServer;

//ServerBootStrap启动一个服务提供者
public class ServerBootStrap {

    public static void main(String[] args) {

        NettyServer.server("127.0.0.1",9999);


    }
}
