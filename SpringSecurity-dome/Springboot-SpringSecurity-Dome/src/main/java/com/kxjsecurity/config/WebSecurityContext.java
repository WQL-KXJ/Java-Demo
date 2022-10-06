package com.kxjsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * @Author WQL-KXJ
 * @ProjectName Springboot-SpringSecurity-Dome
 * @PackageName com.kxjsecurity.config
 * @Date 2022/8/14 16:02
 * @Version 1.0
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityContext extends WebSecurityConfigurerAdapter {

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
                .antMatchers("/wql/a1").hasAuthority("p1")//所有/wql/**的请求必须认证通过
                .anyRequest().permitAll()//除了/wql/))其他请求可以访问
                .and()
                .formLogin()//允许表单登录
                    .loginPage("/loginview")
                    .loginProcessingUrl("/login")
                    .successForwardUrl("/login-success")//自定义登录成功的页面地址
                    .failureForwardUrl("/login-failure")
                    .permitAll();
        http.csrf().disable();
    }
}
