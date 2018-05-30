package com.gupao.springbootjsp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: spring-boot-jsp
 * @description:权限的控制
 * @author:Daniel.zhao
 * @create:2018-05-25 15:42
 **/
@RestController
public class IndexController {

    @RequestMapping(value="/index")
    public String index(){
        return "get index success";
    }


    @RequestMapping(value="/exception/{number}")
    public String index(@PathVariable int number){
        System.out.println(20/number);
        return "exception ~~~";
    }
    @RequestMapping(value="/errors")
    public ModelAndView error(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/error");
       return mav;
    }

//    @RequestMapping(value="/main")
//    public ModelAndView main(){
//        ModelAndView mav=new ModelAndView();
//        mav.setViewName("main");
//        return mav;
//    }

   /* @RequestMapping(value="/login")
    public String login(UserEntity userEntity){
        UserEntity user= (UserEntity) usersService.loadUserByUsername(userEntity.getUsername());
        if(null!=user&&user.getPassword().equals(userEntity.getPassword())){
        }
        return "main";
    }
*/
}
