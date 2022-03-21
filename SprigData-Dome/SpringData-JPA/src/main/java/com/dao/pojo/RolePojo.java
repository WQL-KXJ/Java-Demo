package com.dao.pojo;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class RolePojo {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int roleId;

    @Column(name ="rolename")
    String roleName;

    @Version int version;
    public RolePojo(String roleName) {
        this.roleName = roleName;
    }
    public RolePojo() {

    }
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RolePojo{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
