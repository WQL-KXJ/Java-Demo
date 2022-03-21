package com.dao.pojo;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class MassagePojo {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int messId;

    @Column(name ="info")
    String info;


    public MassagePojo() {

    }

    public int getMessId() {
        return messId;
    }

    public void setMessId(int messId) {
        this.messId = messId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "MassagePojo{" +
                "messId=" + messId +
                ", info='" + info + '\'' +
                '}';
    }
}
