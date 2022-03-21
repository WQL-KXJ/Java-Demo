package com.dao.repsitories;

import com.dao.pojo.jdbctemplatetestpojo;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface StipulateMethod extends CrudRepository<jdbctemplatetestpojo, Integer> {

    //按照name查询
    jdbctemplatetestpojo findByName(String name);

    //判断用户是否存在
    boolean existsById(int id);

    //按照Name统计条数
    int countByName(String name);

    //按照ID和Name删除数据
    @Transactional//增删改时必须加上事务
    int deleteByIdAndName(int id,String name);

}
