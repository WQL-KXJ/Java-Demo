package dome;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

public class Zk_Protogenesis {
    //连接的集群IP和端口
    private static String connectString = "192.168.68.151:2181,192.168.68.152:2181,192.168.68.153:2181";
    private static int sessiontimeout = 2000;
    private static ZooKeeper zkcli;
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
    //ZK客户端分别有三个参数connectString,sessionTimeout,watcher
        zkcli= new ZooKeeper(connectString, sessiontimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //将监听方法放入process中，实现持续监听(zk默认监听只有一次)
                try {
                    GetStatic();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("连接成功！");

        DeleteNode();
        CreateNode();
        GetStatic();

    }

    //创建节点目录
    public static void CreateNode() throws KeeperException, InterruptedException {

        //建一个持久节点
        String node = zkcli.create("/WQL","FQ_ZK".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        System.out.println(node);
    }

    //删除节点
    public static void DeleteNode() throws KeeperException, InterruptedException {

        zkcli.delete("/WQL",0);

    }

    //获取节点信息
    public  static void GetStatic() throws KeeperException, InterruptedException {

        //获取所有节点并开启监听
        List<String> child = zkcli.getChildren("/",true);

        //打印节点
        for(String node:child){
            System.out.println(node);
        }
        //延时
        Thread.sleep(Integer.MAX_VALUE);
    }


}
