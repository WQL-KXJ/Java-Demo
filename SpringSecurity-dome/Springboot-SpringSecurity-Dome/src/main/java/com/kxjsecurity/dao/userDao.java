package com.kxjsecurity.dao;

import com.kxjsecurity.pojo.PessmissionPojo;
import com.kxjsecurity.pojo.SecurityUserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName Springboot-SpringSecurity-Dome
 * @PackageName com.kxjsecurity.dao
 * @Date 2022/8/15 17:59
 * @Version 1.0
 */
@Repository
public class userDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //根据用户名查询用户信息
    public SecurityUserPojo getUserByUserName(String username){

        String SQL = "SELECT id,username,password,fullname,mobile FROM security_user WHERE username=?";

        List<SecurityUserPojo> query = jdbcTemplate.query(SQL, new Object[]{username}, new BeanPropertyRowMapper<SecurityUserPojo>(SecurityUserPojo.class));

        if(query!=null && query.size()==1){

            return query.get(0);
        }

        return null;
    }

    //根据用户ID查询用户权限
    public List<String> findPermissionByUserID(StringBuffer userid){

        String SQL = "SELECT * FROM t_permission WHERE id IN(\n"+
                "SELECT role_id FROM t_role_permission WHERE role_id IN(\n"+
                "SELECT role_id FROM t_user_role WHERE user_id =?\n"+"))";
        List<PessmissionPojo> query = jdbcTemplate.query(SQL, new Object[]{userid}, new BeanPropertyRowMapper<PessmissionPojo>(PessmissionPojo.class));

        ArrayList<String> permission = new ArrayList<>();
        query.forEach((x)->permission.add(x.getCode()));

        return permission;
    }





}
