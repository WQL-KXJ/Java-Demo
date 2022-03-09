package comshiro;

import comshiro.config.authenticat;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

//自定义Realm的实现
public class defindAuthenticator {
    public static void main(String[] args) {

        //创建securityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        //设置自定义realm
        defaultSecurityManager.setRealm(new authenticat());

        //创建工具类
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //subject
       Subject subject = SecurityUtils.getSubject();

       UsernamePasswordToken token = new UsernamePasswordToken("wql","123456");

       try {
           subject.login(token);
       }catch (UnknownAccountException e){
           System.out.println("用户不存在！");
       }catch (IncorrectCredentialsException e){
           System.out.println("密码不存在！");

       }
    }



}
