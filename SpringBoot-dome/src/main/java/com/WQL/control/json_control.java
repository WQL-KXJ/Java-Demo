package com.WQL.control;

import com.WQL.pojo.jdbccrud;
import com.WQL.pojo.yaml_pojo;
import com.WQL.server.select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.Map;

@Controller
public class json_control {

    @Autowired(required=true)
    yaml_pojo wql;

    @Autowired
    DataSource dataSource;

    @Autowired
    select s;

    @ResponseBody
    @RequestMapping("/home")
    public yaml_pojo json(){
        System.out.println(dataSource.getClass());
        return wql;
    }

    @ResponseBody
    @RequestMapping("/select/{id}")
    public jdbccrud jdbccrue(@PathVariable("id") int id){
        jdbccrud a = s.h(id);
        return a;
    }

}
