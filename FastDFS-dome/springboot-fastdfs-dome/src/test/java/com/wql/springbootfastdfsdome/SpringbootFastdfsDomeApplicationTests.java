package com.wql.springbootfastdfsdome;

import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadFileStream;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadFileWriter;
import com.github.tobato.fastdfs.domain.upload.FastFile;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class SpringbootFastdfsDomeApplicationTests {

	@Autowired
	FastFileStorageClient fileStorageClient;

	@Test//文件上传
	void file_upload() throws FileNotFoundException {
		//设置文件的元数据信息
		MetaData metaData =new MetaData("file_name","wql.jpg");
		Set<MetaData> set = new HashSet<>();
		set.add(metaData);

		//读取上传文件的输入流
		File file =new File("wql.jpg");
		FileInputStream inputStream = new FileInputStream(file);

		/*上传文件类
		* 参数：
		* InputStream inputStream：上传文件的输入流
		* long fileSize： 上传文件的大小,通过file.length()方法获取即可
		* String fileExtName： 文件的后缀名
		* Set<MetaData> metaDataSet：文件的元数据信息
		* */
		FastFile fastFile =new FastFile(inputStream,file.length(),"jpg",set);

		StorePath storePath = fileStorageClient.uploadFile(fastFile);


		System.out.println(storePath.getFullPath());
		System.out.println(storePath.getGroup());
		System.out.println(storePath.getPath());

		//获取上传文件的元数据信息
		Set<MetaData> metadata = fileStorageClient.getMetadata(storePath.getGroup(), storePath.getPath());
		//打印输出
		for(MetaData metaData1:metadata){
			System.out.println(metaData1.getName()+": "+metaData1.getValue());
		}
	}

	@Test//文件下载
	void file_download() throws IOException {

		/*上传方法
		* 参数:
		* String groupName:文件的组名
		* String path:文件的地址
		* DownloadCallback<T> callback：上传文件的回调
		* */
		byte[] bytes = fileStorageClient.downloadFile("group1", "M00/00/00/wKhEhWFqgqGAYRfkAAJdc7kXBfI862.jpg", new DownloadByteArray());

		byte[] bufferedInputStream = fileStorageClient.downloadFile("", "", new DownloadByteArray());


		File file =new File("FQ_love_WQL.jpg");
		FileOutputStream fileOutputStream =new FileOutputStream(file);
		fileOutputStream.write(bytes);
	}

	@Test
	void delete_file(){

		fileStorageClient.deleteFile("group1", "M00/00/00/wKhEhWFqgqGAYRfkAAJdc7kXBfI862.jpg");

	}

}
