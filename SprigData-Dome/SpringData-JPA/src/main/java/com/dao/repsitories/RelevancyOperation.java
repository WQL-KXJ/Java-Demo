package com.dao.repsitories;

import com.dao.pojo.CustomerPojo;
import org.springframework.data.repository.CrudRepository;

public interface RelevancyOperation extends CrudRepository<CustomerPojo,Integer> {


}
