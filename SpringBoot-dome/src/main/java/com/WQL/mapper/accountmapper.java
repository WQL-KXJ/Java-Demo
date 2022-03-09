package com.WQL.mapper;

import com.WQL.pojo.jdbccrud;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface accountmapper {

    //纯注解方式
    @Select("select * from  jdbctemplatetest where id=#{id}")
    public jdbccrud select(int id);

    //配置文件方式
    public jdbccrud select1(int id);
}
