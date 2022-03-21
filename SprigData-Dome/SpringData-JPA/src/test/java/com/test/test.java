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
        jdbctemplatetestpojo getbyid = customerRepsitory.getbyid(1);

        System.out.println(getbyid);
    }

    @Test
    public void updata(){
        int kxj = customerRepsitory.updatepojo("KXJ", 2);
        System.out.println(kxj);
    }

    @Test
    public void delete(){
        int deletepojo = customerRepsitory.deletepojo(2);
        System.out.println(deletepojo);
    }

    @Test
    public void insert(){
        int insertpojo = customerRepsitory.insertpojo(1);
        System.out.println(insertpojo);
    }

    @Test
    public  void OriginSql(){

        jdbctemplatetestpojo jdbctemplatetestpojo = customerRepsitory.selectId(1);
        System.out.println(jdbctemplatetestpojo);

    }

}
