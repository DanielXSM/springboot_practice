package com.gupao.springbootjsp.configure;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: spring-boot-jsp
 * @description:拦截器
 * @author:Daniel.zhao
 * @create:2018-04-23 17:02
 **/
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
       /* //登陆不做拦截
        if(request.getRequestURI().equals("/user/login")||request.getRequestURI().equals("/user/login_view")){
            return true;
        }
        //验证session 是否存在
        Object obj=request.getSession().getAttribute("_session_user");
        if(null==obj){
            response.sendRedirect("/user/login_view");
            return false;
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
