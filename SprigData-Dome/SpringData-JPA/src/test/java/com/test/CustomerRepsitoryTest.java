package com.test;


import com.config.JpaManagerFoctoryConfig;
import com.dao.pojo.AccountPojo;
import com.dao.pojo.CustomerPojo;
import com.dao.pojo.MassagePojo;
import com.dao.repsitories.RelevancyOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = JpaManagerFoctoryConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerRepsitoryTest {

//    @Autowired
//    RelevancyOperation relevancyOperation;
//
//    @Test
//    @Transactional
//    @Commit
//    public  void test1(){
//
//        AccountPojo accountPojo = new AccountPojo();
//        accountPojo.setUsername("wql");
//        accountPojo.setPassword(123);
//
//        CustomerPojo customerPojo = new CustomerPojo();
//        customerPojo.setCustName("fq");
//        customerPojo.setCustAddress("changsha");
//        customerPojo.setAccount(accountPojo);
//
//         //relevancyOperation.save(customerPojo);
//        Optional<CustomerPojo> byId = relevancyOperation.findById(1);
//        System.out.println(byId.get());
//    }
//
//    //一对多保存
//    @Test
//    public  void test2(){
//        AccountPojo accountPojo = new AccountPojo();
//        accountPojo.setUsername("wql");
//        accountPojo.setPassword(123);
//
//
//        List<MassagePojo> massagePojos = new ArrayList<>();
//
//
//        CustomerPojo customerPojo = new CustomerPojo();
//        customerPojo.setCustName("fq");
//        customerPojo.setCustAddress("changsha");
//        customerPojo.setAccount(accountPojo);
//        customerPojo.setMassagePojo(massagePojos);
//
//        relevancyOperation.save(customerPojo);
//
//    }

//    //一对多查询
//    @Test
//    @Transactional
//    public void test3(){
//        Optional<CustomerPojo> byId = relevancyOperation.findById(1);
//        System.out.print(byId.get());
//    }


}
