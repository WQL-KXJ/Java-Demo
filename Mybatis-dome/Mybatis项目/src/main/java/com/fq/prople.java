package com.fq;

public class prople {

    int id;
    String name;
    int bmid;
    int age;
    String xb;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBmid(int bmid) {
        this.bmid = bmid;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBmid() {
        return bmid;
    }

    public int getAge() {
        return age;
    }

    public String getXb() {
        return xb;
    }

    @Override
    public String toString() {
        return "prople{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bmid=" + bmid +
                ", age=" + age +
                ", xb='" + xb + '\'' +
                '}';
    }
}
