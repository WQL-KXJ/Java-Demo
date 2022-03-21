package com.test;

import com.config.JpaManagerFoctoryConfig;
import com.dao.pojo.Qjdbctemplatetestpojo;
import com.dao.pojo.jdbctemplatetestpojo;
import com.dao.repsitories.QueryDSL;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@ContextConfiguration(classes = JpaManagerFoctoryConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class test3 {

    @Autowired
    QueryDSL queryDSL;

    @Test
    public void find(){

        //通过QueryDSL的Q类生成查询对象
        Qjdbctemplatetestpojo qjdbctemplatetestpojo = Qjdbctemplatetestpojo.jdbctemplatetestpojo;

        //查询id为1的数据
        BooleanExpression eq = qjdbctemplatetestpojo.id.eq(1);
        qjdbctemplatetestpojo.name.eq("").count();
        Optional<jdbctemplatetestpojo> one = queryDSL.findOne(eq);

        System.out.print(one.get());

    }

}
