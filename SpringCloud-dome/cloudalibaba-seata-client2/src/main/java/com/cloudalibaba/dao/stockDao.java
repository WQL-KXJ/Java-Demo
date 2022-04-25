package com.cloudalibaba.dao;

import com.cloudalibaba.entity.stockpojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface stockDao {

    public boolean update_stock(int productor);


}
