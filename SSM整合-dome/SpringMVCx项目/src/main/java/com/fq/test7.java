package com.fq;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class test7 {

    @RequestMapping(value = "/we",method = RequestMethod.POST)
     public String vc(@RequestParam(value = "upload") MultipartFile upload, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("photo");
        System.out.println(path);
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        //方法直接打印
        upload.transferTo(new File(file,upload.getOriginalFilename()));
        return "seccion";
}

}
