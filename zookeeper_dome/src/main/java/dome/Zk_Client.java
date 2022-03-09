package dome;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

public class Zk_Client {
    private static String connectString = "192.168.68.151:2181,192.168.68.152:2181,192.168.68.153:2181";//服务器IP地址和端口号
    private static int sessiontimeout = 20000;//会话的超时时间
    private static int connectionTimeout =20000;//连接超时时间
    private static ZkClient zkClient;//客户端对象(成员静态变量)
    public static void main(String[] args) {

    zkClient = new ZkClient(connectString,sessiontimeout,connectionTimeout,new SerializableSerializer());

    System.out.println(zkClient);
    }

    //创建节点(创建成功会返回节点名称的字符串)
    public static void CreateNode(){

        //创建持久节点
        zkClient.create("/FQ","6666", CreateMode.PERSISTENT);

        //创建持久序号节点
        zkClient.createPersistentSequential("/FQ/WQL","9999");

        //创建短暂节点
        zkClient.createEphemeral("/FQ/LingShi","1111");

        //创建短暂序号节点
        zkClient.createEphemeralSequential("/FQ/LingShi_Seq","2222");

    }

    //删除节点
    public  static void DeleteNode(){

        zkClient.deleteRecursive("/FQ");

    }

    //查询节点下的子节点并获取数据
    public static void  SelectStat(){
        //获取子节点列表
        List<String> children = zkClient.getChildren("/FQ");

        //获取节点数据
        for(String data:children){
            String NodeData = zkClient.readData("/FQ/" + data);
            System.out.println(NodeData);
        }
    }

    //修改节点
    public static void AlterNode(){

        zkClient.writeData("/FQ","LOVE");

    }

    //节点的监听
    public static void  WatchNode(){

        zkClient.subscribeDataChanges("/FQ", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("数据被修改！");
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("数据被删除！");
            }
        });

    }
}
