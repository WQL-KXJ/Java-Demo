package wql.serviceimpl;

import org.apache.dubbo.config.annotation.Service;
import wql.service.getservice;

/*
* dubbo和Spring都有一个service注解：
* 1，dubbo中的service：将这个类提供的方法(或服务)对外发布，将访问的地址，ip，端口号注册到注册中心
* 2，spring中的service：将类对象创建出来，放到Spring的IOC容器中
* */
@Service//使用dubbo的service
public class getserviceimpl implements getservice {
    public String wql() {
        return "hello fq";
    }
}
