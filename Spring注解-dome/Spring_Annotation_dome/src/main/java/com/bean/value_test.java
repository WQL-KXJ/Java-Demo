package com.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class value_test {

    @Value("${name}")
    String name;
    @Value("${age}")
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
        return "value_test{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
