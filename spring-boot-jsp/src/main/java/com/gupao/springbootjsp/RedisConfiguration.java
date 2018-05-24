package com.gupao.springbootjsp;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;


/**
 * @program: spring-boot-jsp
 * @description:redis 缓存
 * @author:Daniel.zhao
 * @create:2018-05-24 11:44
 **/

//@EnableCaching注解来开启我们的项目支持缓存
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport
{


    /**
 * 采用redisCacheManager作为缓存管理器
     * 我们在配置类内添加了方法cacheManager()，
     * 方法的返回值则是使用了我们的Redis缓存的管理器，
     * SpringBoot项目启动时就会去找自定义配置的CacheManager对象并且自动应用到项目中。
 */
@Bean
public CacheManager cacheManager(RedisTemplate redisTemplate){

    return new RedisCacheManager(redisTemplate);
}

    /**
     * 自定义生成key 的规则
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                //格式化缓存key字符串
                StringBuilder sb=new StringBuilder();
                //追加类名
                sb.append(o.getClass().getName());
                //追加方法名
                sb.append(method.getName());
                //遍历参数,并且追加
                for(Object obj:objects){
                    sb.append(obj.toString());
                }
                System.out.println("调用redis 缓存key："+sb.toString());
                return sb.toString();
            }
        };


    }
}
