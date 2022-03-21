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
import org.springframework.util.StringUtils;

@ContextConfiguration(classes = JpaManagerFoctoryConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class test5 {

    @Autowired
    QueryDSL queryDSL;

    @Test
    public void find() {

        jdbctemplatetestpojo jdbctemplatetestpojo= new jdbctemplatetestpojo();
        jdbctemplatetestpojo.setId(0);
        jdbctemplatetestpojo.setName("WQL,FQ");
        jdbctemplatetestpojo.setMoney(4000);

        Qjdbctemplatetestpojo qjdbctemplatetestpojo = Qjdbctemplatetestpojo.jdbctemplatetestpojo;
        //动态查询
        BooleanExpression expression = qjdbctemplatetestpojo.isNotNull().or(qjdbctemplatetestpojo.isNull());
        expression = jdbctemplatetestpojo.getId()>-1?
                qjdbctemplatetestpojo.id.gt(jdbctemplatetestpojo.getId()):expression;
        expression = StringUtils.isEmpty(jdbctemplatetestpojo.getName())?
                qjdbctemplatetestpojo.name.in(jdbctemplatetestpojo.getName().split(",")):expression;
        expression = StringUtils.isEmpty(jdbctemplatetestpojo.getMoney())?
                qjdbctemplatetestpojo.money.eq(4000):expression;


        System.out.print(queryDSL.findAll(expression));


    }

    }
