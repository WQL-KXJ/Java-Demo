package com.example.springboot_mybatisplus_dome.myenum;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Data;
import lombok.ToString;

@ToString
public enum myenum implements IEnum<Integer> {
    NAN(0,"男"),
    NV(1,"女");

    private int num;
    private String sex;

    myenum(int num, String sex) {
        this.num = num;
        this.sex = sex;
    }

    @Override
    public Integer getValue() {
        return this.num;
    }
}
