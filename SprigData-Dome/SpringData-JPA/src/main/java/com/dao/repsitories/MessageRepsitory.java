package com.dao.repsitories;

import com.dao.pojo.CustomerPojo;
import com.dao.pojo.MassagePojo;
import com.dao.pojo.jdbctemplatetestpojo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepsitory extends CrudRepository<MassagePojo, Integer> {

    //多对一查询只能在单的一方查询才是完整的
    //通过规定方法名进行匹配，通过关联属性进行匹配
    //只能通过属性中的id进行匹配
    List<MassagePojo> findByCustomerPojo(CustomerPojo c );
}
