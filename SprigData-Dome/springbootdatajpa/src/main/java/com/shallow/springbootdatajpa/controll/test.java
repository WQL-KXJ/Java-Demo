package com.shallow.springbootdatajpa.controll;

import com.shallow.springbootdatajpa.dao.pojo.jdbctemplatetestpojo;
import com.shallow.springbootdatajpa.dao.repository.CustomerRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class test {

    @Autowired
    CustomerRepsitory customerRepsitory;

    @RequestMapping("/test")
    public jdbctemplatetestpojo j(){
        Optional<jdbctemplatetestpojo> byId = customerRepsitory.findById(1);

        return byId.get();
    }

}
