package comshiro.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class authenticMD5 extends AuthorizingRealm {
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

       String a=(String) authenticationToken.getPrincipal();

       if(a.equals(a)){

           return  new SimpleAuthenticationInfo("wql",
                   "2c064f94210cdde60d828fd85a0671a3",
                   ByteSource.Util.bytes("123456"),//加Salt操作，在判断时会先加上salt后加密
                   this.getName());

       }

        return null;
    }
}
