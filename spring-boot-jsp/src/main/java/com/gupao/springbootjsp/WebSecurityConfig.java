package com.gupao.springbootjsp;

import com.gupao.springbootjsp.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @program: spring-boot-jsp
 * @description:SpringSecurity 的配置
 * @author:Daniel.zhao
 * @create:2018-05-25 14:57
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //完成自定义认证实体注入
    @Bean
    UserDetailsService userService(){return new UserService();}


    /**
     * 第一句我们仅用了csrd，在springSecurity4.0后，默认开启了CSRD拦截，如果需要配置请在form表单添加如下图12配置：
     * <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></input>
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable()
               .authorizeRequests().
               anyRequest().
               authenticated()//所有请求必须登陆后访问
               .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()//登陆界面和错误界面可以直接访问
               .and().logout().permitAll();//注销请求可以直接访问

    }
}
