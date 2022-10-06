package com.kxjsecurity.servicer;

import com.kxjsecurity.dao.userDao;
import com.kxjsecurity.pojo.SecurityUserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName Springboot-SpringSecurity-Dome
 * @PackageName com.kxjsecurity.servicer
 * @Date 2022/8/14 15:40
 * @Version 1.0
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    userDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //1.将来连接数据库根据账号查询用户信息
        SecurityUserPojo userByUserName = userDao.getUserByUserName(s);

        if(userByUserName==null){
            return null;
        }
        //2. 通过用户ID查询权限
        List<String> permissionByUserID = userDao.findPermissionByUserID(new StringBuffer().append(userByUserName.getId()));

        //3. 将permissionByUserID转化成数组
        String[] permissions = new String[permissionByUserID.size()];
        permissionByUserID.toArray(permissions);

        //2.登录账号
        UserDetails build = User.withUsername(userByUserName.getUsername()).password(userByUserName.getPassword()).authorities(permissions).build();
        return build;
    }
}
