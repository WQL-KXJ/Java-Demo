package com.kxjsecurity.springmvc.interceptor;

import com.kxjsecurity.springmvc.pojo.UserDetails;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @Author WQL-KXJ
 * @ProjectName Session-dome
 * @PackageName com.kxjsecurity.springmvc.interceptor
 * @Date 2022/8/12 17:44
 * @Version 1.0
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {

    //通过这个方法效验用户请求是否在权限范围内
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //1.通过session判断用户是否登录
        Object attribute = request.getSession().getAttribute(UserDetails.SESSION_USER_KEY);

        if(attribute==null) {
            //没有认证提示登录
            writeContent(response,"请登录");
        }

        UserDetails userDetails = (UserDetails)attribute;
        //请求URL
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        System.out.println(userDetails.getUsername()+"\t"+userDetails.getAuthorities());
        if(userDetails.getAuthorities().contains("a1") && requestURI.contains("/wql/status")){
            return true;
        }

        if(userDetails.getAuthorities().contains("a2") && requestURI.contains("/wql/resource")){
            return true;
        }

        writeContent(response,"没有权限访问！");
        return false;
    }

    //响应信息给前端
    private void writeContent(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(message);
        writer.close();
    }
}
