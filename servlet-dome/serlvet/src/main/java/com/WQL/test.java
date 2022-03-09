package com.WQL;

import javax.servlet.*;
import java.io.IOException;

public class test implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
            System.out.println("Serlvet启动init!!!!");
    }

    @Override
    public ServletConfig getServletConfig() {

        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
                System.out.println("WQL love FQ");

    }

    @Override
    public String getServletInfo() {


        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Servlet关闭！！");
    }
}
