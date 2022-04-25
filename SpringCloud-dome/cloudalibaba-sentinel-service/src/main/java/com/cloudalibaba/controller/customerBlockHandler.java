package com.cloudalibaba.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloudalibaba.util.CommonResult;

public class customerBlockHandler {

    public static CommonResult ByHandler(BlockException blockexception){ //一定要加static
        return new CommonResult(444,"服务不可用被限流");
    }
}
