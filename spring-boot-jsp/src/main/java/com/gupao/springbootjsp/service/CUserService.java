package com.gupao.springbootjsp.service;

import com.gupao.springbootjsp.jpa.UserJPA;
import com.gupao.springbootjsp.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring-boot-jsp
 * @description:cache redis  缓存
 * @author:Daniel.zhao
 * @create:2018-05-25 17:10
 **/
@Service
@CacheConfig(cacheNames = "user")
public class CUserService {

        @Autowired
        private UserJPA userJPA;

        /**
         * 该注解是用来开启声明的类参与缓存,如果方法内的@Cacheable注解没有添加key值，
         * 那么会自动使用cahceNames配置参数并且追加方法名。
         * @Cacheable：配置方法的缓存参数，可自定义缓存的key以及value。
         *
         */
        @Cacheable
        public List<UserModel> list(){
            return userJPA.findAll();
        }

        @Cacheable
        public UserModel save(UserModel userEntity) {
            return userJPA.save(userEntity);
        }


        @Cacheable
        public List<UserModel> findByName(String name){
            return userJPA.queryListByCondition(name);
        }

    }

