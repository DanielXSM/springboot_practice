package com.gupao.springbootjsp.controller;

import com.gupao.springbootjsp.model.Person;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/25.
 */
@Controller
@EnableAutoConfiguration
public class welcome {
    private Logger logger= LoggerFactory.getLogger(welcome.class);
    @RequestMapping("")
    public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView();
        Map<String,Object> modelmap=modelAndView.getModel();
        modelAndView.setViewName("index");
        logger.debug("come to welcome controller");
        System.out.println("666666");
        return modelAndView;
    }
//    @RequestMapping("/index")
//    @ResponseBody
//    public String index(HttpServletRequest request, HttpServletResponse response){
//        logger.debug("come to welcome controller");
//        return "aaaaa";
//    }
    @GetMapping("/hello")
    public ResponseEntity indexs(HttpServletRequest request, HttpServletResponse response){
        logger.debug("come to welcome controller");
//        return ResponseEntity.ok("ResponseEntity~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return ResponseEntity.ok(new Person("儿子",18,"老子"));
    }
    @GetMapping("/errors")
    public ResponseEntity error(HttpServletRequest request, HttpServletResponse response){
        logger.debug("come to welcome controller");
//        return ResponseEntity.ok("ResponseEntity~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if(1==1){

            throw new  RuntimeException("跑出来的小猪");
        }
        System.out.println("chijile");
        return ResponseEntity.ok(new Person("儿子",18,"老子"));
    }


}
