package com.wqls;

import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface imbwql {
    @Select("select * from bm")
    public List<bmswql> select();
}
