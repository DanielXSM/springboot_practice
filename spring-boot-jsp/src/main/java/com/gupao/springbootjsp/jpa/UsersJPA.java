package com.gupao.springbootjsp.jpa;

import com.gupao.springbootjsp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: spring-boot-jsp
 * @description:权限的用户表
 * @author:Daniel.zhao
 * @create:2018-05-25 14:40
 **/
public interface UsersJPA extends JpaRepository<UserEntity,Long>{

    //使用springdatajpa 方法定义查询
     UserEntity findByUsername(String username);
}
