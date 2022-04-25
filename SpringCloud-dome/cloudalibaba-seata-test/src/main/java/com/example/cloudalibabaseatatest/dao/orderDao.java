package com.example.cloudalibabaseatatest.dao;


import com.example.cloudalibabaseatatest.entity.orderpojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface orderDao {

   public boolean insert_order(orderpojo orderpojo);

}
