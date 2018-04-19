package com.gupao.springbootjsp.controller;

import com.gupao.springbootjsp.jpa.UserJPA;
import com.gupao.springbootjsp.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;
    @RequestMapping(value="/list")
    public List<UserEntity> list(){
        return userJPA.findAll();
    }

    @RequestMapping(value="/save")
    public UserEntity save(UserEntity userEntity){
        return userJPA.save(userEntity);
    }
    @RequestMapping(value="/delete")
    public List<UserEntity> delete(Long id){
        userJPA.delete(id);
        return userJPA.findAll();
    }



}
