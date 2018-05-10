package com.gupao.springbootjsp.controller;

import com.gupao.springbootjsp.jpa.UserJPA;
import com.gupao.springbootjsp.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserController {
    private static final Logger logger=LoggerFactory.getLogger(UserController.class);
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

    @RequestMapping(value="/login")
    public String login(final UserEntity user,HttpServletRequest request){
        String result="index";
        UserEntity userEntity=userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"),user.getName()));
                return null;
            }
        });
        //用户不存在
        if(null==userEntity){

             result="no user";
        }
        //密码错误
        else if(!userEntity.getPwd().equals(user.getPwd())){
            result="password error";
        }
        request.getSession().setAttribute("_session_user",userEntity.getId());
        return result;
    }

    /**
     * 初始化登陆页面
     *
     * @return
     */
    @RequestMapping(value = "/login_view", method = RequestMethod.GET)
    public String login_view(HttpServletRequest request, HttpServletResponse response) {
        logger.info("主页访问~~~~");
        logger.debug("主页访问~~~~");
        logger.error("主页访问~~~~");
        return "login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        logger.info("主页访问~~~~");
       return "index";
    }



    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("_session_user");
        return "redirect:/user/login_view";
    }
}
