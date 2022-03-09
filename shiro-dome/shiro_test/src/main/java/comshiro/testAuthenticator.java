package comshiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class testAuthenticator {

    public static void main(String[] args) {

        //1，创建安全管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        //2，给安全管理器设置realm(获取安全实体数据源)
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));

        //3，SecurityUtils 给全局的安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);

        //4，提供工具类获取subject关键对象
        Subject subject = SecurityUtils.getSubject();

        //5，创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("wql","12s3");

        try {
            System.out.println(subject.isAuthenticated());
            subject.login(token);
            System.out.println(subject.isAuthenticated());
        //常见异常UnknownAccountException用户名不存在 IncorrectCredentialsException密码不存在
        }catch (UnknownAccountException a){
            System.out.println("用户名不存在！！");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码不存在");

        }



    }


}
