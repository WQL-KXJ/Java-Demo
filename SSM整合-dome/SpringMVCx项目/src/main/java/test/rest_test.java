package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class rest_test {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String get(){

        return "get";
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public String post(){

        return "post";
    }

    @RequestMapping(value = "/put",method = RequestMethod.PUT)
    public String put(){

        return "put";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public String delete(){

        return "delete";
    }
}
