package com.test;

import com.config.JpaManagerFoctoryConfig;
import com.dao.pojo.jdbctemplatetestpojo;
import com.dao.repsitories.Specifications;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.Optional;

@ContextConfiguration(classes = JpaManagerFoctoryConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class test4 {

    @Autowired
    Specifications specifications;

    @Test
    public void find(){

        Optional<jdbctemplatetestpojo> one = specifications.findOne(new Specification<jdbctemplatetestpojo>() {
            @Override
            public Predicate toPredicate(Root<jdbctemplatetestpojo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //作用于那个字段
                Path<Object> name = root.get("name");
                Path<Object> money = root.get("money");
                //设置条件
                Predicate wql = criteriaBuilder.equal(name, "WQL");
                Predicate equal = criteriaBuilder.equal(money, 4000);
                criteriaBuilder.and(wql,equal);
                return wql;
            }
        });

        System.out.print(one.get());

    }

}
