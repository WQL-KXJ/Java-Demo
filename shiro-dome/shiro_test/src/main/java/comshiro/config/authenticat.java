package comshiro.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class authenticat extends AuthorizingRealm {
        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
            return null;
        }

        @Override
        //这个方法只做数据名的认证，密码在底层实现，只需要提交SimpleAuthenticationInfo带上密码就行
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
            //获取用户名
            String token = (String) authenticationToken.getPrincipal();
            //根据身份信息使用jdbc mybatis查询数据库对比
            if("wql".equals(token)){

                SimpleAuthenticationInfo simpleAuthenticationInfo=  new SimpleAuthenticationInfo("wql","123456",this.getName());

                return simpleAuthenticationInfo;
            }
            return null;
    }
}
