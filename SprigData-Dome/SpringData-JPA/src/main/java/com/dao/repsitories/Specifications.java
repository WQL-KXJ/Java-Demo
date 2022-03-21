package com.dao.repsitories;

import com.dao.pojo.jdbctemplatetestpojo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface Specifications extends CrudRepository<jdbctemplatetestpojo, Integer>, JpaSpecificationExecutor<jdbctemplatetestpojo> {
}
