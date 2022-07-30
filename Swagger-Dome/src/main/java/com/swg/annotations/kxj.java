package com.swg.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Author WQL-KXJ
 * @ProjectName Swagger-Dome
 * @PackageName com.swg.annotations
 * @Date 2022/7/30 16:02
 * @Version 1.0
 */
@Target({ElementType.METHOD,ElementType.TYPE}) //注解的作用范围(方法和类上)
@Retention(RetentionPolicy.RUNTIME)//注解的有效范围(运行时有效)
public @interface kxj {
    String value() default "";
}
