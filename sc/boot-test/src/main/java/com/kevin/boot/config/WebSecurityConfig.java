package com.kevin.boot.config;

import com.kevin.boot.security.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Spring Security相关配置
 * Created by Administrator on 2016/12/27 0027.
 */
@Configuration
//@EnableWebSecurity //spring boot自动开启了相关配置
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserDetailService() {
        return new CustomUserDetailService();
    }

    /**
     * 请求授权
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests() //开始请求权限配置
                .antMatchers("/", "/login").permitAll()//设置Spring Security对“/”和“/login”不拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")//设置登录页面的访问路径
                .defaultSuccessUrl("/chat")
                .permitAll()
                .and()
                .logout().permitAll();
    }

    /**
     * 用户认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //内存用户
        /*auth.inMemoryAuthentication()
                .withUser("kevin").password("kevin").roles("USER") //在内存中分配两个用户
                .and()
                .withUser("any").password("any").roles("USER");*/

        //自定义
        auth.userDetailsService(customUserDetailService());
    }

    @Override
    public  void configure(WebSecurity web) {
        //配置静态资源不进行拦截
        web.ignoring().antMatchers("/resources/web/static/**");
    }
}