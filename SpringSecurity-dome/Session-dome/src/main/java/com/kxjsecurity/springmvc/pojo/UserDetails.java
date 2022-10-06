package com.kxjsecurity.springmvc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/*
 * @Author WQL-KXJ
 * @ProjectName Session-dome
 * @PackageName com.kxjsecurity.springmvc.pojo
 * @Date 2022/8/11 22:54
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    public static final String SESSION_USER_KEY="_user";
    String id;
    String username;
    String password;
    String fullname;
    String mobile;
    Set<String> authorities;

    public UserDetails(String id, String username, String password,Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities=authorities;
        this.fullname="";
        this.mobile="";
    }
}
