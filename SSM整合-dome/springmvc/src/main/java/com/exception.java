package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//标识当类为一个异常组件
@ControllerAdvice
public class exception {

    @ExceptionHandler({ArithmeticException.class})
    //标注ExceptionHandler注解的方法，形参为Exception类型的话，异常错误信息会被自动注入
    public String exception(Exception e, Model model){
        //将异常信息放入域中
        model.addAttribute("excepion",e);
        return "error";
    }

}
