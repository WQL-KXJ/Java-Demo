package com.example.springboot_mybatisplus_dome.dao.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("mybatistest")
public class activerecord_pojo extends Model<activerecord_pojo> {
    @TableId(type = IdType.AUTO)
    int id;

    String name;
    int sex;
    int age;
}
