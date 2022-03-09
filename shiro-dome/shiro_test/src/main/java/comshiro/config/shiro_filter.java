package comshiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import comshiro.shiro_.realm_;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

//用来整合shiro框架相关的配置类
@Configuration
public class shiro_filter  {

    @Bean("shiroDialect")//thymeleaf整合shiro需要方言
    public ShiroDialect shiroDialect(){

        return  new ShiroDialect();
    }

    //1,创建shirofilter,负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
     //给拦截器工厂设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置受限资源和公共资源
        Map<String,String> map =new HashMap<String,String>();

        map.put("/login","anon");
        map.put("/register","anon");
        map.put("/**","authc");
        ///认证
        // 界面路径
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
    //2,创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){

        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();

        //给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;

    }

    //3,创建自定义Realm
    @Bean
    public Realm getRealm(){
        realm_ realm_a=new realm_();
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        realm_a.setCredentialsMatcher(hashedCredentialsMatcher);

        //开启Realm的缓存(使用EhCatche)
        realm_a.setCacheManager(new EhCacheManager());
        //开启全局的缓存
        realm_a.setCachingEnabled(true);
        //开启认证的缓存
        realm_a.setAuthenticationCachingEnabled(true);
        //开启授权的缓存
        realm_a.setAuthorizationCachingEnabled(true);
        //设置默认的名字
        realm_a.setAuthenticationCacheName("AuthenticationionCache");
        realm_a.setAuthorizationCacheName("AuthorizationCache");

        return realm_a;
    }

}
