package com.bean;

public class init_dostroy_test {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public init_dostroy_test(String name) {
        this.name = name;
        System.out.println("bean有参创建！");
    }

    //初始化方法
    public void init(){
        System.out.println("init_dostroy_test初始化！");
    }

    //销毁方法
    public void destroy(){
        System.out.println("init_dostroy_test销毁！");
    }
}
