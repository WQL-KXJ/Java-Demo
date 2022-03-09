package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class attribute {

    @ResponseBody
    @RequestMapping
    //获取Request请求域中name和sex并赋给形参
    public Map<String,Object> att(@RequestAttribute("name") String m,@RequestAttribute("sex")int s){

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name",m);
        map.put("sex",s);
        return map;
    }
}
