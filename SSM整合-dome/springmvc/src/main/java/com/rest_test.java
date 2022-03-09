package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/user")
public class rest_test {

    @RequestMapping(value = "/wql",method = RequestMethod.GET)
    public String get(){
        return "get";
    }

    @RequestMapping(value = "/wql/{id}",method = RequestMethod.GET)
    public String getall(@PathVariable("id") String id){
        System.out.println(id);
        return "get";
    }

    @RequestMapping(value = "/wql",method = RequestMethod.POST)
    public String post(){

        return "post";
    }

    @RequestMapping(value = "/wql",method = RequestMethod.PUT)
    public String put(){

        return "put";
    }

    @RequestMapping(value = "/wql",method = RequestMethod.DELETE)
    public String delete(){

        return "delete";
    }
}
