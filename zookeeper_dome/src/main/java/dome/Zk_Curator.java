package dome;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.Backgroundable;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.listen.ListenerContainer;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class Zk_Curator {

    //创建一个重试策略类型
    static RetryPolicy  retryPolicy =new ExponentialBackoffRetry(3000,10);

    //连接的IP和端口
    static String connectString = "192.168.68.151:2181,192.168.68.152:2181,192.168.68.153:2181";

    //会话超时时间(连接有时需要时间，不能把时间设置太短)
    static int sessionTimeoutMs = 20000;

    //连接超时时间
    static int connectTimeoutMs = 20000;

    //客户端对象
    static CuratorFramework curatorFramework;

    public static void main(String[] args) {

        //获取客户端对象
       curatorFramework = CuratorFrameworkFactory.newClient(connectString,sessionTimeoutMs,connectTimeoutMs,retryPolicy);

        //开启客户端(和其他API有些不一样，它是同步的)
        curatorFramework.start();

    }

    //创建节点
    public static void CreateNode() throws Exception {
        //创建临时节点
        curatorFramework.create().withMode(CreateMode.EPHEMERAL).forPath("/WQL","FQ_6".getBytes());

    }

    //修改节点
    public static void AlterNode() throws Exception {

        curatorFramework.setData().forPath("/WQL","Alter".getBytes());

    }

    //删除节点
    public static void DeleteNode() throws Exception {

        curatorFramework.delete().inBackground(new BackgroundCallback(){//添加删除回调方法
            @Override
            public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                System.out.println("删除/WQL节点成功！");
            }
        }).forPath("/WQL");
    }

    //NodeCache监听节点
    public static void WatchNode() throws Exception {

        //创建NodeCache
        NodeCache nodeCache = new NodeCache(curatorFramework,"/WQL",false);

        //获取监听事件列表
        ListenerContainer<NodeCacheListener> list = nodeCache.getListenable();

        //注册监听事件
        list.addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("节点被修改！");
            }
        });

        //开启监听
        nodeCache.start(false);
    }



    //关闭客户端
    public static void ColseCurator(){

        curatorFramework.close();

    }

}
