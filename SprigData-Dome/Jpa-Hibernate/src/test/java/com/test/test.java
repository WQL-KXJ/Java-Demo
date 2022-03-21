package com.test;

import com.config.JpaManagerFoctoryConfig;
import com.dao.pojo.jdbctemplatetestpojo;
import com.dao.repsitories.CustomerRepsitory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@ContextConfiguration(classes = JpaManagerFoctoryConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class test {

    @Autowired
    CustomerRepsitory customerRepsitory;

    @Test
    public void selectget(){
        Optional<jdbctemplatetestpojo> getbyid = customerRepsitory.findById(1);

        System.out.println(getbyid.get());
    }



}
