package com.test;

import com.config.JpaManagerFoctoryConfig;
import com.dao.pojo.Qjdbctemplatetestpojo;
import com.dao.pojo.jdbctemplatetestpojo;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ContextConfiguration(classes = JpaManagerFoctoryConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class test6 {

    @PersistenceContext//为每一个线程绑定一个EntityManager，避免线程安全问题
    EntityManager entityManager;

    @Test
    public void ww(){

        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);

        //QueryDSL的Q类
        Qjdbctemplatetestpojo pojo = Qjdbctemplatetestpojo.jdbctemplatetestpojo;

        //原生查询+QueryDSL
        JPAQuery<Tuple> wql = jpaQueryFactory.select(pojo.name, pojo.money)
                .from(pojo)
                .where(pojo.name.eq("WQL"))
                .orderBy(pojo.id.desc());

        List<Tuple> fetch = wql.fetch();

        for(Tuple s:fetch){
            System.out.print(fetch);
        }


    }

}
