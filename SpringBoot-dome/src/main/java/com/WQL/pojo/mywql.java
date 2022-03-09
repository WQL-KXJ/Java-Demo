package com.WQL.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


//只有再容器中的组件才能进行配置绑定，所有需要Component加入容器中
@Component
@ConfigurationProperties(prefix = "mywql")
public class mywql {

    String name;
    String girlfriends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGirlfriends() {
        return girlfriends;
    }

    public void setGirlfriends(String girlfriends) {
        this.girlfriends = girlfriends;
    }

    @Override
    public String toString() {
        return "mywql{" +
                "name='" + name + '\'' +
                ", girlfriends='" + girlfriends + '\'' +
                '}';
    }
}
