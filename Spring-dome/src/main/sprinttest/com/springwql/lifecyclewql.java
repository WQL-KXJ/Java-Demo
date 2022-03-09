package com.springwql;

public class lifecyclewql {
    String name;

    public lifecyclewql(){

        System.out.println("1,构造创建bean");
    }

    public void setName(String name) {
        System.out.println("2，属性注入赋值(set)");
        this.name = name;
    }

    public void initwql(){//初始化方法

        System.out.println("4,初始化方法开始执行");
    }

    public void destroywql(){//销毁方法
        System.out.println("7,bean销毁");
    }

    @Override
    public String toString() {
        return "lifecyclewql{" +
                "name='" + name + '\'' +
                '}';
    }
}
