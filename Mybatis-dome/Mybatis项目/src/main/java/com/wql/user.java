package com.wql;

import java.io.Serializable;

public class user implements Serializable {
    int id;
    String name;
    int random;

    public  user(){


    }
    public user(int id, String name, int random) {
        this.id = id;
        this.name = name;
        this.random = random;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", random=" + random +
                '}';
    }
}
