package com.example.springboot_mybatisplus_dome.dao.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.example.springboot_mybatisplus_dome.myenum.myenum;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("mybatistest")
public class mybatisplus_pojo {
    @TableId(type = IdType.AUTO)
    int id;
    @TableField(fill = FieldFill.INSERT)
    String name;
    myenum sex;
    int age;
    @TableLogic//标记逻辑删除字段
    int deleteid;
}
