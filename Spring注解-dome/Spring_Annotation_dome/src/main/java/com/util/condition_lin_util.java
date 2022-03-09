package com.util;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class condition_lin_util implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Environment environment = context.getEnvironment();

        String os_type = environment.getProperty("os.name");

        if(os_type.contains("linux")){

            return true;
        }


        return false;
    }
}
