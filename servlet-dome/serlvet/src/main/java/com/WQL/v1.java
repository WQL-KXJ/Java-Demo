package com.WQL;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/v2")//拦截的路径
public class v1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器！！！");
        filterChain.doFilter(servletRequest,servletResponse);//放行请求到Servlet
    }

    @Override
    public void destroy() {

    }
}
