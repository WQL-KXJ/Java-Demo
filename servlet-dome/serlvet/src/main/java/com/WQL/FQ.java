package com.WQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/FQ520")
public class FQ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie a = new Cookie("name","FQloveWQL");
        Cookie a1 = new Cookie("names","FQloveWQLs");
        a.setMaxAge(60*60);//设置数cookie时间
        a.setPath("/serlvet_war_exploded/fq");//设置路径携带cookie
        resp.addCookie(a);//添加进响应头中
        resp.addCookie(a1);
        req.setAttribute("name","hehe");
        req.getRequestDispatcher("fq1").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
