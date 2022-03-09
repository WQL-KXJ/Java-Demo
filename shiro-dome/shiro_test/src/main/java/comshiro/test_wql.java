package comshiro;

import comshiro.config.authenticMD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;

public class test_wql {
    public static void main(String[] args) {
        //1，创建安全管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //创建自定义Realm实例
        authenticMD5 authenticMD5= new authenticMD5();

        //创建Hash算法匹配器
        HashedCredentialsMatcher hashedCredentialsMatcher=  new HashedCredentialsMatcher();

        //设置匹配器中的算法类型
        hashedCredentialsMatcher.setHashAlgorithmName("md5");

        //设置散列的次数
        hashedCredentialsMatcher.setHashIterations(123);//默认是一次

        //将算法匹配器加入到Realm中
       authenticMD5.setCredentialsMatcher(hashedCredentialsMatcher);

        //2，给安全管理器设置realm(获取安全实体数据源)
        securityManager.setRealm(authenticMD5);
        //3，SecurityUtils 给全局的安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);

        //4，提供工具类获取subject关键对象
        Subject subject = SecurityUtils.getSubject();

        //5，创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("wql","123456");

        try {
            subject.login(token);
            //常见异常UnknownAccountException用户名不存在 IncorrectCredentialsException密码不存在
        }catch (UnknownAccountException a){
            System.out.println("用户名不存在！！");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码不存在");

        }

    }

}
