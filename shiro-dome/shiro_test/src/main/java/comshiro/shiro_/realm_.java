package comshiro.shiro_;

import comshiro.bean.wql;
import comshiro.spring_service.wql_service;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import  comshiro.config.appllicationContextUtil;
import org.springframework.util.ObjectUtils;

public class realm_ extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取主身份信息,就是用户认证通过后的名称
        String sf=(String) principalCollection.getPrimaryPrincipal();
        System.out.println("授权验证："+sf);
        if("FQ".equals(sf)){
            SimpleAuthorizationInfo simpleAuthorizationInfo =new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addRole("admin");
            return simpleAuthorizationInfo;

        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        appllicationContextUtil app = new appllicationContextUtil();


        wql_service wqlService =(wql_service)app.getbean("wql_service");

        String auth = (String) authenticationToken.getPrincipal();

        wql w = wqlService.sele(auth);

        System.out.println("+++++++++++++++++++++++++++++++");
        if(!ObjectUtils.isEmpty(w)){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(w.getName(),w.getRandom(),this.getName());
            System.out.println(w.getName()+"-----"+w.getRandom());
            return simpleAuthenticationInfo;
        }

        return null;
    }
}
