package com.mapper;


import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.pojo.mybatistest;

public interface mybatistest_mapper {

//    @Select("select * from mybatistest where id=#{id}")
    public mybatistest selere_id(int id);

}
