package com.fq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Interwql {
@RequestMapping(value = "/wqwq",method = RequestMethod.GET )
public  String f(HttpServletRequest request){
    //获取请求类型
    System.out.println("tt");
    return "seccion";
}
}
