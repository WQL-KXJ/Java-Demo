package com.swg.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/*
 * @Author WQL-KXJ
 * @ProjectName Swagger-Dome
 * @PackageName com.swg.entity
 * @Date 2022/7/31 0:14
 * @Version 1.0
 */
@ApiModel
public class wql implements Serializable {

    @ApiModelProperty(value = "主键",name = "主键（ID）",required = false,dataType = "字符串")
    String id;

    @ApiModelProperty(value = "用户名",name = "验证",required = false)
    String name;

    @ApiModelProperty(value = "密码",name = "验证",required = false)
    String password;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        wql wql = (wql) o;
        return Objects.equals(id, wql.id) &&
                Objects.equals(name, wql.name) &&
                Objects.equals(password, wql.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
