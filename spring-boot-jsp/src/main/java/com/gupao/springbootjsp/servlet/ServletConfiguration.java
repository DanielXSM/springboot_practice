package com.gupao.springbootjsp.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-boot-jsp
 * @description:servlet配置
 * @author:Daniel.zhao
 * @create:2018-05-09 17:08
 **/
@Configuration
public class ServletConfiguration {

    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new TestServlet(),"/test");

    }
}
