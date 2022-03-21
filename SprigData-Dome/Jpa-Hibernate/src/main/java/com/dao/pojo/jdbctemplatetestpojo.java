package com.dao.pojo;


import javax.persistence.*;

@Entity //声明这是Hibernate的实体类
@Table(name = "jdbctemplatetest")//跟表做映射
public class jdbctemplatetestpojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键的生成策略,这里是自增
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "money")
    int money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "jdbctemplatetestpojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
