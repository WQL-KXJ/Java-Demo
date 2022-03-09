package com.WQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/v2")
public class v2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter a=resp.getWriter();
        a.println("<html>");
        a.println("<head>");
        a.println("</head>");
        a.println("<body>");
        a.println("<h1>过滤器</h1>");
        a.println("</body>");
        a.println("</html>");
    }
}
