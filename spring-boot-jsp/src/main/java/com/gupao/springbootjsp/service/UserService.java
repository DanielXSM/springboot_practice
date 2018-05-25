package com.gupao.springbootjsp.service;

import com.gupao.springbootjsp.entity.UserEntity;
import com.gupao.springbootjsp.jpa.UsersJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @program: spring-boot-jsp
 * @description:权限
 * @author:Daniel.zhao
 * @create:2018-05-25 17:08
 **/
public class UserService implements UserDetailsService{

        @Autowired
        UsersJPA usersJPA;


        /**
         * 现UserDetailsService接口需要完成loanUserByUsername重写，
         * 我们使用UserJPA内的findByUsername方法从数据库中读取用户，并将用户作为方法的返回值。
         * @param username
         * @return
         * @throws UsernameNotFoundException
         */
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            UserEntity user=usersJPA.findByUsername(username);
            if(null==user){
                throw new UsernameNotFoundException("未查询到用户:"+username+"信息");
            }
            return user;
        }



    }




