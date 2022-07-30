package com.swg.config;

import com.google.common.base.Predicates;
import com.swg.annotations.kxj;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/*
 * @Author WQL-KXJ
 * @ProjectName Swagger-Dome
 * @PackageName com.swg.config
 * @Date 2022/7/30 15:53
 * @Version 1.0
 */
@Configuration
public class AnnotationSwgConfig {

    @Bean
    public Docket docket(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.select()
                .apis(//当值为flase不生成接口文档，当值为true生成
                        Predicates.not(//对true取反
                                Predicates.or(RequestHandlerSelectors.withMethodAnnotation(kxj.class),//扫描方法上是否有@kxj注解,有返回true
                                        RequestHandlerSelectors.withClassAnnotation(kxj.class))//扫描类上是否有@kxj注解,有返回true
                        )
                ).build();

        return docket;
    }


}
