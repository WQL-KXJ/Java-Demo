package com.kxjsecurity.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/*
 * @Author WQL-KXJ
 * @ProjectName Spring-SpringSecurity-Dome
 * @PackageName com.kxjsecurity.config
 * @Date 2022/8/12 22:51
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //1，定义用户信息服务
    @Bean
    public UserDetailsService userDetailsService(){

        //基于内存的用户信息服务
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("lishi").password("123").authorities("a1").build());
        manager.createUser(User.withUsername("wangwu").password("123").authorities("a2").build());
        return manager;
    }

    //2，密码编码器
    @Bean
    public PasswordEncoder passwordEncoder(){
        //不需要对密码进行编码
        return NoOpPasswordEncoder.getInstance();
    }

    //3，安全拦截机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/wql/t1").hasAuthority("a1")//访问/wql/t1必须要有a1权限
                .antMatchers("/wql/t2").hasAuthority("a2")//访问/wql/t2必须要有a2权限
                .antMatchers("/wql/**").authenticated()//所有/wql/**的请求必须认证通过
                .anyRequest().permitAll()//除了/wql/))其他请求可以访问
                .and()
                .formLogin()//允许表单登录
                .successForwardUrl("/login-success");//自定义登录成功的页面地址
    }
}
