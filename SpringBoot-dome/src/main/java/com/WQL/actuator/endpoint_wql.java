package com.WQL.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "myEndpoint")
public class endpoint_wql {

    @ReadOperation
    public Map get(){

        Map map =new HashMap();
        map.put("class","com.wql.llllread");
        return map;
    }

    @WriteOperation
    public void set(){
        System.out.println("操作端点");
    }
}
