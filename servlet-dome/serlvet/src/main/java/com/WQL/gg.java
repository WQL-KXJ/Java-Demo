package com.WQL;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(value = "/luoqin")
public class gg  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println(req.getServletPath());//获取Servlet路径
        System.out.println(req.getContextPath());//获取Servlet项目路径
        System.out.println(req.getServerName());//获取Servlet名称
        System.out.println(req.getServerPort());//获取Servlet端口号
        System.out.println(req.getCharacterEncoding());//获取编码字符集
        System.out.println(req.getParameter("name"));//按照参数名获取参数值
        Enumeration<String> a = req.getParameterNames();





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
