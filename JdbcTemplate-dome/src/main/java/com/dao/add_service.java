package com.dao;

import com.bean.jdbctemplatetest;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class add_service implements add_service_in {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int update(jdbctemplatetest template) {

        //写法一
       int seccuss= jdbcTemplate.update("insert into jdbctemplatetest values (?,?,?)",template.getId(),template.getName(),template.getAge());

       //写法二
        Object[] value = {template.getId(),template.getName(),template.getAge()};
        jdbcTemplate.update("insert into jdbctemplatetest values (?,?,?)",value);
        return seccuss;
    }

    //更新
    @Override
    public int alter(jdbctemplatetest template) {

        String sql = "update jdbctemplatetest set name=?,age=? where id=?";
        Object[] val ={template.getName(),template.getAge(),template.getId()};
        int a = jdbcTemplate.update(sql,val);
        return a;
    }

    //删除
    @Override
    public int delete(jdbctemplatetest template) {
        String sql = "delete from jdbctemplatetest where id=?";
        int i = jdbcTemplate.update(sql, template.getId());
        return i;
    }

    @Override
    public int[] add_batch(List<Object[]> value) {

        String SQL = "insert into jdbctemplatetest values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(SQL, value);
        return ints;
    }

    @Override
    public int[] alter_batch(List<Object[]> value) {

        String SQL = "update jdbctemplatetest set name=?,age=? where id=?";
        int[] ints = jdbcTemplate.batchUpdate(SQL, value);
        return ints;
    }

    @Override
    public int[] delete_batch(List<Object[]> value) {

        String SQL = "update jdbctemplatetest set name=?,age=? where id=?";
        int[] ints = jdbcTemplate.batchUpdate(SQL, value);
        return ints;
    }
}
