package minio_test;

import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.Bucket;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {

        /*构建一个minio客户端对象：创造者模式构建
        * 方法：
        * 1，endpoint()：指定远程minio的url地址，可以string和URL类型
        * 2，credentials()：指定用户名和密码(在minio中访问密钥对于账号，秘密密钥对于密码)
        * 3，build()：构建一个minio客户端对象
        * */
        MinioClient minioclient = MinioClient.builder()
                .endpoint("http://192.168.68.134:9000")
                .credentials("minioadmin","minioadmin")
                .build();

        /*
        * 构建一个桶对象：
        * 1，builder：构建对象
        * 2，bucket：桶的名称
        * 3，build：返回对象
        * */
        BucketExistsArgs wql = BucketExistsArgs.builder().bucket("wql").build();
        boolean b = minioclient.bucketExists(wql);
        if(b){
            System.out.println("桶存在！");
        }else {
            System.out.println("桶不存在！正在创建");
            minioclient.makeBucket(MakeBucketArgs.builder().bucket("wql").build());
        }

        //文件上传
        UploadObjectArgs upload = UploadObjectArgs.builder().bucket("wql").object("wql.jpg").filename("C:\\gg.jpg").build();
        ObjectWriteResponse objectWriteResponse = minioclient.uploadObject(upload);

        //文件下载
        DownloadObjectArgs download = DownloadObjectArgs.builder().filename("d:\\hh.jpg").bucket("wql").object("wql.jpg").build();
        minioclient.downloadObject(download);

    }
}
