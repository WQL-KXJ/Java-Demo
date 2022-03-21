package com.test;

import com.config.JpaManagerFoctoryConfig;
import com.dao.pojo.CostomerRolePojo;
import com.dao.pojo.RolePojo;
import com.dao.repsitories.CustomerRoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.plugin.javascript.navig.LinkArray;

import javax.management.relation.Role;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(classes = JpaManagerFoctoryConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerRoleTest {

    @Autowired
    CustomerRoleRepository customerRoleRepository;

    @Test
    @Transactional
    public void wql(){

        List<RolePojo> list = new ArrayList<>();
        list.add(new RolePojo("商品管理员"));
        list.add(new RolePojo("超级管理员"));

        CostomerRolePojo costomerRolePojo = new CostomerRolePojo();
        costomerRolePojo.setCustName("SMT");
        costomerRolePojo.setCustAddress("changsha");
        costomerRolePojo.setRolePojos(list);

        customerRoleRepository.save(costomerRolePojo);


    }

}
