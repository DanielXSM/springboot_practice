package com.gupao.springbootjsp.service;

import com.gupao.springbootjsp.jpa.UserJPA;
import com.gupao.springbootjsp.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring-boot-jsp
 * @description:
 * @author:Daniel.zhao
 * @create:2018-05-24 14:55
 **/
@Service
@CacheConfig(cacheNames = "user")
public class UserService {
    @Autowired
    private UserJPA userJPA;

    /**
     * 该注解是用来开启声明的类参与缓存,如果方法内的@Cacheable注解没有添加key值，
     * 那么会自动使用cahceNames配置参数并且追加方法名。
     * @Cacheable：配置方法的缓存参数，可自定义缓存的key以及value。
     *
     */
    @Cacheable
    public List<UserEntity> list(){
    return userJPA.findAll();
    }

    @Cacheable
    public UserEntity save(UserEntity userEntity) {
        return userJPA.save(userEntity);
    }


    @Cacheable
    public List<UserEntity> findByName(String name){
        return userJPA.queryListByCondition(name);
    }

}
