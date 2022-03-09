package com.wqls;

import java.io.Serializable;

public class bmswql implements Serializable {
    int id;
    String bmname;

    public void setId(int id) {
        this.id = id;
    }

    public void setBmname(String bmname) {
        this.bmname = bmname;
    }

    public int getId() {
        return id;
    }

    public String getBmname() {
        return bmname;
    }

    @Override
    public String toString() {
        return "bm{" +
                "id=" + id +
                ", bmname='" + bmname + '\'' +
                '}';
    }

}
