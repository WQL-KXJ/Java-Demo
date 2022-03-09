package com.bean;

public class lazy_test {

    String name;
    int age;

    public lazy_test(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
        return "lazy_test{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
