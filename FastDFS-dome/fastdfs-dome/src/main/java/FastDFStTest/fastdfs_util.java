package FastDFStTest;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

public class fastdfs_util {



    public fastdfs_util() throws IOException, MyException {
    }

    //文件上传
    public void upload() throws IOException, MyException {

        //引入配置文件，并初始化
        ClientGlobal.init("fastdfs.conf");

        //获取Tracker客户端对象
        TrackerClient trackerClient = new TrackerClient();
        //获取Trackerserver对象
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        /*获取Storageserver对象，它依赖于tracker对象
         * 参数：
         *     TrackerServer trackerServer：Trackerserver对象
         * */
        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);

        /*定义Storage客户端对象，通过这个对象实现文件的上传，下载，删除等操作(关键对象)
         * 需要传入的参数：
         * 1，TrackerServer trackerServer：Tracker服务对象
         * 2，StorageServer storageServer：Storage服务对象
         * */
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);

        /*文件上传：使用StorageClient类的upload_file方法
        *1，local_filename：上传文件路径
        *2，file_ext_name：文件后缀名
        *3，meta_list：文件的属性文件(通常不用)
        * 返回值为String[]类型，返回的属性非常重要(group和访问地址)，这个属性一般保存再数据库中
        * */
       String[] up_meta = storageClient.upload_file("fq.jpg","jpg",null);

       //将属性进行打印group，访问地址
       for (String a:up_meta){
           System.out.println(a);
       }

       //关闭storage客户端
       storageClient.close();
    }

    //文件下载
    public void download() throws IOException, MyException {

        //前面部分是一样的，没有进行提前了
        ClientGlobal.init("fastdfs.conf");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);

        //组名
        String group = "group1";
        //地址
        String remote = "M00/00/00/wKhEhWFpboSABPB4AABGckhMKZw455.jpg";
        //下载到本地的文件名
        String filename = "wql.jpg";

        /*使用download_file进行文件的下载，这种方法重载也挺多，有返回值为byte和int的，这里使用的是返回值为int类型的
        * String group_name：远程文件的组名
        * String remote_filename：文件地址
        * String local_filename：保存到本地的文件路径和文件名
        * */
       int a = storageClient.download_file(group,remote,filename);

       //假如a为0就为失败，否则反正
       if(a!=0){
           System.out.println("下载成功！");
       }
        storageClient.close();
    }

    //删除文件
    public void delete_remote_file() throws IOException, MyException {

        ClientGlobal.init("fastdfs.conf");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);

        //组名
        String group = "group1";
        //地址
        String remote = "M00/00/00/wKhEhWFpboSABPB4AABGckhMKZw455.jpg";

        /*delete_file没有重载方法
        * 参数：
        * String group_name：组名
        * String remote_filename：地址
        * */
        int a = storageClient.delete_file(group,remote);
        if(a!=0){
            System.out.println("删除成功");
        }
        storageClient.close();
    }
}
