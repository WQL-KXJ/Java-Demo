package com.WQL.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExampleInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {

        Map<String,Object> map = new HashMap<>();
        map.put("mavenversion","1.1.1");
        map.put("name","WQL");
        builder.withDetails(map);
    }
}
