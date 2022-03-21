package com.shallow.springbootdatajpa.dao.repository;

import com.shallow.springbootdatajpa.dao.pojo.jdbctemplatetestpojo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


//CrudRepository需要指定两个泛型，第一个为实体类，第二个为主键的类型
public interface CustomerRepsitory extends CrudRepository<jdbctemplatetestpojo, Integer> {

    //查询操作
    @Query("from jdbctemplatetestpojo pojo where pojo.id=?1")
    public jdbctemplatetestpojo getbyid(int id);

    //修改操作
    @Transactional//事务
    @Modifying//表示该方法为增删改方法
    @Query("UPDATE jdbctemplatetestpojo p SET p.name = :newname where p.id = :id  ")
    int updatepojo(@Param("newname") String name, @Param("id") int id);

    //删除方法
    @Transactional
    @Modifying
    @Query("DELETE FROM jdbctemplatetestpojo p WHERE p.id = ?1")
    int deletepojo(int id);

    //插入操作
    @Transactional
    @Modifying
    @Query("INSERT INTO jdbctemplatetestpojo (name, money) SELECT c.name, c.money FROM jdbctemplatetestpojo c WHERE c.id = ?1")
    int insertpojo(int id);

    @Query(value = "SELECT * FROM jdbctemplatetest where id = ?1",nativeQuery = true)//必须使用表名，而不能想JPQL一样使用类名
    public jdbctemplatetestpojo selectId(int id);

}
