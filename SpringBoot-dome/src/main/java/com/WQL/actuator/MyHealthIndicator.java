package com.WQL.actuator;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyHealthIndicator extends AbstractHealthIndicator {
    @Override

    protected void doHealthCheck(Health.Builder builder) throws Exception {

        Map<String,Object> map = new HashMap<>();

        if(1==1){
            builder.up();
            map.put("message",1);
        }else {
            builder.down();
            map.put("message",0);
        }

        builder.withDetails(map);
    }
}
