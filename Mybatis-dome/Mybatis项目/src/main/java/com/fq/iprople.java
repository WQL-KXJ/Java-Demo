package com.fq;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface iprople {
    //select查询的四种方式
    //1，单条数据查询(保存到javaBean)
    public prople select1(int id);

    //2,多条数据查询(list集合封装)
    public Page<prople> select2();

    //3,单条数据查询(保存到Map集合)
    public Map<String,String> select3(int id);

    //4,多条数据查询(保存到Map集合)
    @MapKey(value = "id")
    public  Map<Integer,prople> select4();
}
