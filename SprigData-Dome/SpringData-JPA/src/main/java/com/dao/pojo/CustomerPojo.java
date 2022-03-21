package com.dao.pojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerPojo {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int custId;

    @Column(name ="cust_name")
    String custName;

    @Column(name ="cust_address")
    String custAddress;

    @OneToOne(cascade =CascadeType.ALL )
    @JoinColumn(name ="account_id")
    AccountPojo account;

//    @OneToMany(cascade =CascadeType.ALL)
//    @JoinColumn(name = "customer_id")//一对多，外键创建在多的一方的表里面
//    List<MassagePojo> massagePojo;


    public int getCustId() {
        return custId;
    }

    public void setCustId(int cusItd) {
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

    public AccountPojo getAccount() {
        return account;
    }

    public void setAccount(AccountPojo account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "CustomerPojo{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", account=" + account +
                '}';
    }
}
