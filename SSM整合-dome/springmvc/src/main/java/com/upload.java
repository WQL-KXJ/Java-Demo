package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@ResponseBody
public class upload {

    @RequestMapping("/upload")
    public String upload(MultipartFile multipartFile, HttpSession session) throws IOException {



        //通过session对象获取Context对象，通过这个对获取要上传的服务器路径
        ServletContext context = session.getServletContext();

        //获取文件的上传到的服务器路径
        String path = context.getRealPath("photo");
        System.out.println(path);
        //上传文件不存在就创建
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }

        //获取上传文件的初始名称
        String originalFilename = multipartFile.getOriginalFilename();

        //获取上传文件的后缀名(对原生文件名按照.为分割解析截取)
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));

        //得到随机UUID作为文件名
        String uuid = UUID.randomUUID().toString();

        //对UUID文件名和后缀进行拼接
        String newfilename = uuid+substring;

        //上传后的文件路径（File.separator为文件发分割符）
        String afterpath = path+File.separator+newfilename;

        //上传文件
        multipartFile.transferTo(new File(afterpath));

        return "success";
    }
}
