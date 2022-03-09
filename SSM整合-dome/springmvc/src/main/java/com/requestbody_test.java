package com;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@Controller
@RestController
public class requestbody_test {

    @RequestMapping("/requestbodya")
    public String requestbody(@RequestBody String map){

        //System.out.println(map);

        return "post";
    }

    @RequestMapping("/requestbody")
    public String requestbody(RequestEntity<String> entity){

        System.out.println(entity.toString());

        return "post";
    }

    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {

        response.getWriter().println("asdqwdasjksfa");
    }

    @RequestMapping("/responsebody")
    @ResponseBody
    public String response()  {

        return "wql";
    }
}
