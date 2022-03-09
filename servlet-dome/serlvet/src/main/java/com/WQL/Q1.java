package com.WQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/Q1")
public class Q1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在作用域中设置值
        req.setAttribute("name","傅晴");
        req.setAttribute("names","王清霖");
        //转发
        req.getRequestDispatcher("/Q2").forward(req,resp);
    }


}
