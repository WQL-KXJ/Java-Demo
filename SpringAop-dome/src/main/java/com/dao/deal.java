package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class deal implements deal_interface {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int in(String name,int money) {

        String SQL = "update jdbctemplatetest set money=money+? where name=?";
        int i = jdbcTemplate.update(SQL,money,name);
        return i;
    }

    public int out(String name,int money) {

        String SQL = "update jdbctemplatetest set money=money-? where name=?";
        int i = jdbcTemplate.update(SQL,money,name);
        return i;
    }
}
