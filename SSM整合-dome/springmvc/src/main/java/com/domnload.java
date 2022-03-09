package com;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class domnload {

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpSession session) throws IOException {

        //通过session获取context
        ServletContext context = session.getServletContext();

        //获取文件在服务器中路径,开发中这个文件名是从前端获取的
        String realPath = context.getRealPath("/static/img/wql.png");

        //创建一个输入流,
        InputStream inputStream =new FileInputStream(new File(realPath));

        //创建一个字节数组，并将数据通过输入流读到数组中,这个数组的长度通过流的大小指定
        byte[] bytes = new byte[inputStream.available()];

        //数据读到数据中
        inputStream.read(bytes);

        //创建Http响应头信息(可选)
        HttpHeaders httpHeaders = new HttpHeaders();
        //添加响应信息,设置下载方式和下载后的文件名字
        httpHeaders.add("Content-Disposition","attachment;filename=wql.png");

        //设置响应的状态码
        HttpStatus httpStatus = HttpStatus.OK;

        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes,httpHeaders,httpStatus);

        //返回
        return  responseEntity;
    }
}
