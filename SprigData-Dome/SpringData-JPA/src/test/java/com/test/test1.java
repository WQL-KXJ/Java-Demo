package com.test;

import com.config.JpaManagerFoctoryConfig;
import com.dao.pojo.jdbctemplatetestpojo;
import com.dao.repsitories.CustomerRepsitory;
import com.dao.repsitories.StipulateMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = JpaManagerFoctoryConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class test1 {

    @Autowired
    StipulateMethod stipulateMethod;

    @Test
    public void findbyname(){
        jdbctemplatetestpojo fq = stipulateMethod.findByName("FQ");
        System.out.print(fq);
    }

    @Test
    public void existbyid(){
        boolean fq = stipulateMethod.existsById(1);
        System.out.print(fq);
    }

    @Test
    public void countbyname(){
        int fq = stipulateMethod.countByName("FQ");
        System.out.print(fq);
    }

    @Test
    public void deleteidandname(){
        int fq = stipulateMethod.deleteByIdAndName(1, "FQ");
        System.out.print(fq);
    }

}

