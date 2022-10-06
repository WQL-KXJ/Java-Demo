package com.kxjsecurity.springmvc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @Author WQL-KXJ
 * @ProjectName Session-dome
 * @PackageName com.kxjsecurity.springmvc.pojo
 * @Date 2022/8/11 22:57
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class authenticationRequest {

    String username;

    String password;

}
