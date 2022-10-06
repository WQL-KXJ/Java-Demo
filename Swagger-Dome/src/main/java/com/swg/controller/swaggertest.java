package com.swg.controller;

import com.swg.annotations.kxj;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import java.io.InputStream;

/*
 * @Author WQL-KXJ
 * @ProjectName Swagger-Dome
 * @PackageName com.swg.controller
 * @Date 2022/7/29 23:14
 * @Version 1.0
 */
@RestController
//@Api(tags = {"myGet","mypost"},description = "Swagger测试")
public class swaggertest {

    @GetMapping("/getswagger")
    //@ApiOperation(value = "get请求swagger生成文档测试",notes = "重要提示信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user",value ="用户名权限验证",paramType = "字符串",required = true,example = "wql-kxj"),
            @ApiImplicitParam(name = "password",value ="密码权限验证",paramType = "字符串",required = true,example = "wql-kxj")
    })
    public String getswagger(String user, Integer password){

        return "Get Mothed Swagger";
    }

//    @PostMapping("/postswagger")
//    public String postswagger(){
//
//        return "Post Mothed Swagger";
//    }

    @RequestMapping("/mothedswagger")
    @kxj
    public String mothedswagger(){

        return "Mothed Swagger";
    }
}
