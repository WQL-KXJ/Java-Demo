package com.dao.pojo;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class AccountPojo {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int accId;

    @Column(name ="username")
    String username;

    @Column(name ="password")
    int password;

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountPojo{" +
                "accId=" + accId +
                ", username='" + username + '\'' +
                ", password=" + password +
                '}';
    }
}
