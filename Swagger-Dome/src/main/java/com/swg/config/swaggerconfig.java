package com.swg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/*
 * @Author WQL-KXJ
 * @ProjectName Swagger-Dome
 * @PackageName com.swg.config
 * @Date 2022/7/30 12:42
 * @Version 1.0
 */
//@Configuration
public class swaggerconfig {

    /*
     *构建Docket类型的对象，并使用spring容器进行管理
     *Docket是Swagger中的全局配置对象
     */
 //   @Bean
    public Docket docket(){
        //创建一个Docket对象，参数：文件类，这里使用SWAGGER_2类型文档
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        //API帮助文档的描述信息对象
        ApiInfo apiInfo = new ApiInfoBuilder()
                .contact(//发布者信息
                        new Contact("空想家",//文档发布者名称
                                "https://wql.luoqin.ltd",//文档发布者地址或者企业网站
                                "2562694007@qq.com"))//文档发布者邮箱
                .title("Swagger框架学习帮助文档")//文档发布的标题
                .description("Swagger框架学习帮助文档详细描述 -- Swagger是一个由于开发RestAPI帮助文档的框架")//文档描述
                .version("1.1")//文档发布的版本
                .build();
        docket.apiInfo(apiInfo);
        docket.select()
                .apis(RequestHandlerSelectors.basePackage("com.swg.controller"))
                .paths(PathSelectors.regex("/swaggerwql/.*")).build();


        return docket;
    }


}
