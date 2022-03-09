package com.example.springboot_mybatisplus_dome;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot_mybatisplus_dome.dao.pojo.activerecord_pojo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class activerecord {

    @Test
    public void test1(){
        activerecord_pojo activerecordpojo = new activerecord_pojo();

        activerecord_pojo pojo = activerecordpojo.selectById(1L);
        System.out.println(pojo);

        QueryWrapper<activerecord_pojo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","da");

        List<activerecord_pojo> pojos = activerecordpojo.selectList(queryWrapper);
        System.out.println(pojos);
    }
    @Test
    void delete(){
        activerecord_pojo activerecordpojo = new activerecord_pojo();
        QueryWrapper<activerecord_pojo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","da").eq("age","21");
        //按照条件删除
        boolean delete = activerecordpojo.delete(queryWrapper);
        System.out.println(delete);
    }
    @Test
    void insert(){
        activerecord_pojo activerecordpojo = new activerecord_pojo();
        //设置插入的信息
        activerecordpojo.setName("model_insert");
        activerecordpojo.setAge(12);
        activerecordpojo.setSex(1);

        boolean insert = activerecordpojo.insert();
        System.out.println(insert);
    }


    @Test
    void update(){
        activerecord_pojo activerecordpojo = new activerecord_pojo();
        //设置更新的信息,按照id更新的话，必须设置id
        activerecordpojo.setId(6);
        activerecordpojo.setName("model_update");
        activerecordpojo.setAge(12);
        activerecordpojo.setSex(1);

        boolean b = activerecordpojo.updateById();
        System.out.println(b);
    }
}
