package com.bean;

import org.springframework.context.annotation.Configuration;

public class bean_test {

    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "config_annotation{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public bean_test(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
