package wql;


import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class service_web {

    /*
     Reference注解：
     1，从zookeeper注册中心获取注入对象的访问url
     2，进行远程调用RPC
     3，将结果封装为一个代理对象，给变量赋值
     */
    @Reference
    getservice service;

    @RequestMapping(value = "/wql")
    @ResponseBody
    public String fq(){

        return service.wql()+"  WQL";
    }
}

