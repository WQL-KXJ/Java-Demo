package com.dao.pojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customerrole")
public class CostomerRolePojo {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int custId;

    @Column(name ="cust_name")
    String custName;

    @Column(name ="cust_address")
    String custAddress;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(//中间表需要@JoinTable来维护外键和设置
            name = "customer_role",//中间表
            joinColumns = {@JoinColumn(name = "c_id")},//设置本表的外键名称
            inverseJoinColumns = {@JoinColumn(name = "r_id")}//设置中间表的外键名称
    )
    List<RolePojo> rolePojos;

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public List<RolePojo> getRolePojos() {
        return rolePojos;
    }

    public void setRolePojos(List<RolePojo> rolePojos) {
        this.rolePojos = rolePojos;
    }

    @Override
    public String toString() {
        return "CostomerRolePojo{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", rolePojos=" + rolePojos +
                '}';
    }
}