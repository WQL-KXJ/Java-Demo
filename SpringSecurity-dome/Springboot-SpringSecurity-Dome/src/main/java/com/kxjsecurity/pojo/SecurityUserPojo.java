package com.kxjsecurity.pojo;

import lombok.Data;

/*
 * @Author WQL-KXJ
 * @ProjectName Springboot-SpringSecurity-Dome
 * @PackageName com.kxjsecurity.pojo
 * @Date 2022/8/15 17:54
 * @Version 1.0
 */
@Data
public class SecurityUserPojo {

    private int id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
