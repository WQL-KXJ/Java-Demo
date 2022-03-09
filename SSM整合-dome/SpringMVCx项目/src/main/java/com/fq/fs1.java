package com.fq;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class fs1 {
    @RequestMapping("/fs1")
    public String va(MultipartFile upload, HttpServletRequest request) throws IOException {
        //在项目路径下，创建文件夹
        System.out.println("方式1！！！");
        String path = request.getServletContext().getRealPath("fs1");
        String name = upload.getOriginalFilename();//获取上传的文件名
        //判断文件是否存在，不存在创建
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        //获取上传的文件输入流
        InputStream inputStream = upload.getInputStream();
        //获取文件的输出流
        OutputStream outputStream = new FileOutputStream(new File(file,name));
        //文件的复制
        int a=0;
        byte[] bytes = new byte[1024];
        while ((a=inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,a);
        }
        inputStream.close();
        outputStream.close();

        return "seccion";
    }
}
