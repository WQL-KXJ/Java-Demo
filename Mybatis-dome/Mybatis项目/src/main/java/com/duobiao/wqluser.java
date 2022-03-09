package com.duobiao;

import java.io.Serializable;

public class wqluser implements Serializable {
    int id;
    String name;
    int age;
    String xb;
    int bmid;
    bm bms;


    public void setBmid(int bmid) {
        this.bmid = bmid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public void setBmname(bm bms) {
        this.bms = bms;
    }

    public bm getBms() {
        return bms;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getXb() {
        return xb;
    }



    public bm getBmname() {
        return bms;
    }

    @Override
    public String toString() {
        return "wqluser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", xb='" + xb + '\'' +
                ", bmname=" + bms +
                ", bmid=" + bmid +
                '}';
    }
}
