package com.test;

import com.config.JpaManagerFoctoryConfig;
import com.dao.pojo.jdbctemplatetestpojo;
import com.dao.repsitories.QueryExampleExecutor;
import com.dao.repsitories.StipulateMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@ContextConfiguration(classes = JpaManagerFoctoryConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class test2 {

    @Autowired
    QueryExampleExecutor queryExampleExecutor;

    @Test
    public void findone(){
        //pojo实体类对象，通过对象设置查询条件
        jdbctemplatetestpojo pojo = new jdbctemplatetestpojo();
        pojo.setName("FQ");//设置查询的条件是Name为FQ

        //ExampleMatcher进行条件过滤
        ExampleMatcher exampleMatcher =ExampleMatcher.matching()
                                        .withIgnorePaths("id")//忽略id字段的条件
                                        .withIgnoreCase("name");//设置忽略name字段的大小写

        //通过pojo和exampleMatcher匹配器构建查询
        Example example =Example.of(pojo,exampleMatcher);

        //查询
        Optional<jdbctemplatetestpojo> one = queryExampleExecutor.findOne(example);

//        System.out.print(one.get());
    }
}
