package com.cloudalibaba.dao;

import com.cloudalibaba.entity.orderpojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface orderDao {

   public boolean insert_order(orderpojo orderpojo);

}
