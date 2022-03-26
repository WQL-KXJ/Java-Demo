package com.example.springboot_springsession.wql;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
public class test {

    @RequestMapping("/setsession")
    public void setsession(HttpServletRequest request,HttpServletResponse response) throws IOException{

        request.getSession().setAttribute("key","WQL SpringBoot SpringSession");
        response.getWriter().println("WQL SpringBoot SpringSession");

    }

    @RequestMapping("/getsession")
    public void getsession(HttpServletRequest request,HttpServletResponse response) throws IOException{

        String a = (String) request.getSession().getAttribute("key");
        response.getWriter().println(a);
    }

}

