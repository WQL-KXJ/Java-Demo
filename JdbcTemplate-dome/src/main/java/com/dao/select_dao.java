package com.dao;

import com.bean.jdbctemplatetest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class select_dao implements select_dao_in {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询返回单个值
    @Override
    public int query_int() {

        String SQL = "select count(*) from jdbctemplatetest";
        Integer integer = jdbcTemplate.queryForObject(SQL, Integer.class);

        return integer;
    }

    //查询返回对象
    @Override
    public jdbctemplatetest queue_bean(int id) {

        String SQL = "select * from jdbctemplatetest where id=?";

        jdbctemplatetest object = jdbcTemplate.queryForObject(SQL, jdbctemplatetest.class, id);
        return object;
    }

    //查询返回集合
    @Override
    public List<jdbctemplatetest> queue_list() {

        String SQL = "select * from jdbctemplatetest";
        //写法一
       jdbcTemplate.queryForList(SQL, jdbctemplatetest.class);

        //写法二
        List<jdbctemplatetest> jdbctemplatetestslist = jdbcTemplate.query(SQL,new BeanPropertyRowMapper<jdbctemplatetest>(jdbctemplatetest.class));

        return jdbctemplatetestslist;
    }
}
