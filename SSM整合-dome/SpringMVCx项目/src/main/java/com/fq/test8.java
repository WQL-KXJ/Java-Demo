package com.fq;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class test8 {
    @RequestMapping(value = "/FQlove")
    public String addddd(HttpServletRequest request) throws Exception {
        //上传位置
        String path = request.getServletContext().getRealPath("/wqlfq");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        //获取request的上传文件项
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload =new ServletFileUpload(diskFileItemFactory);
        //解析request
        List<FileItem> item=servletFileUpload.parseRequest(request);

        //遍历
        for(FileItem item1 : item){
            //判断当前FileItem是否是上传文件项
            if(item1.isFormField()){
                //它为true说明是普通表单项
            }else {
                //上传文件项
                String name = item1.getName();
                System.out.print(name);
                item1.write(new File(path,name));
            }

        }
        System.out.print("文件上传！！！");
        return "seccion";
    }


}
