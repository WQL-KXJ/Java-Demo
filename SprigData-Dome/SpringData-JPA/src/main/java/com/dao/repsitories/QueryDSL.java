package com.dao.repsitories;

import com.dao.pojo.jdbctemplatetestpojo;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface QueryDSL extends CrudRepository<jdbctemplatetestpojo, Integer>, QuerydslPredicateExecutor<jdbctemplatetestpojo> {
}
