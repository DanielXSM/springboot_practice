package com.gupao.springbootjsp;

import com.gupao.springbootjsp.configure.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置资源文件映射
 */
@Configuration
public class Config extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/a/static/**").addResourceLocations("/static/");
        super.addResourceHandlers(registry);
    }*/
}
