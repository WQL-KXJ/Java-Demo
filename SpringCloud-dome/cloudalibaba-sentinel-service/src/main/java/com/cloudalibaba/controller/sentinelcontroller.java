package com.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloudalibaba.util.CommonResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class sentinelcontroller {

    @GetMapping("/testA")
    public String test1(){

        int a=10/0;
        return "------> testA";
    }

    @GetMapping("/testB")
    public String test2(){
        return "------> testB";
    }

    @GetMapping("/testHotKey")
    /*
    * 1,value：值必须唯一之后在服务端可以使用它来做资源的唯一标识
    * 2,blockHandler：但触发了热点规则使用那个方法进行兜底
    * */
    @SentinelResource(value = "testHotKey",blockHandler = "reveal")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {//定义两个参数

       return "----------ToHetKey---------";
    }

    //兜底方法必须要和原方法参数一致，可以加一个异常变量
    public String reveal(String p1, String p2, BlockException e){

        return "热点限流/(ㄒoㄒ)/~~";
    }

    @GetMapping("/ByResource")
    @SentinelResource(value = "ByResource",blockHandler = "ByHandler",fallback ="ByFallback" )
    public CommonResult ByResource(){
        int t = 10/0;//异常代码
        return new CommonResult(200,"对指定资源进行限流");
    }
    public  CommonResult ByHandler(BlockException blockexception){ //一定要加static
        return new CommonResult(444,"控制台规则");
    }
    public  CommonResult ByFallback(Throwable throwable){ //一定要加static
        return new CommonResult(445,"业务异常");
    }
}
