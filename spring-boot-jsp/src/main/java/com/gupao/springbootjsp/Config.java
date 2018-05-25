package com.gupao.springbootjsp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置资源文件映射
 */
@Configuration
public class Config extends WebMvcConfigurerAdapter {
    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/a/static/**").addResourceLocations("/static/");
        super.addResourceHandlers(registry);
    }*/

    /**
     * 我们来配置一个简单的SpringBoot内的MVC控制器跳转，
     * 重写addViewControllers()方法添加路径访问，可以通过Get形式的/login访问到我们的login.jsp，
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        super.addViewControllers(registry);
    }
}
