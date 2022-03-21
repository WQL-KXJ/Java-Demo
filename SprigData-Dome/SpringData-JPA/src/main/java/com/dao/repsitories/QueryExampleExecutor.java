package com.dao.repsitories;

import com.dao.pojo.jdbctemplatetestpojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface QueryExampleExecutor extends CrudRepository<jdbctemplatetestpojo, Integer>, QueryByExampleExecutor<jdbctemplatetestpojo> {




}
