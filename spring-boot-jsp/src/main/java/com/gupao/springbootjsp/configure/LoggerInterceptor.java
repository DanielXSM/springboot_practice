package com.gupao.springbootjsp.configure;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gupao.springbootjsp.jpa.LoggerJPA;
import com.gupao.springbootjsp.model.LoggerEntity;
import com.gupao.springbootjsp.util.LoggerUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: spring-boot-jsp
 * @description:日志拦截
 * @author:Daniel.zhao
 * @create:2018-04-28 16:57
 **/
public class LoggerInterceptor implements HandlerInterceptor{
    //请求开始时间的标识
    private static final String LOGGER_SEND_TIME="_send_time";
    private static final String LOGGER_ENTITY="_logger_entity";

    /**
     * 进入springmvc 的controller 之前开始记录日志实体
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //创建日志实体
        LoggerEntity logger=new LoggerEntity();
        //获取请求的sessionId
        String sessionId=request.getRequestedSessionId();
        //请求路径
        String url=request.getRequestURI();
        //获取请求参数信息
        String paramData= JSON.toJSONString(request.getParameterMap(), SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteMapNullValue);
        //设置客户端的ip
        logger.setClientip(LoggerUtils.getClientIp(request));
        //设置请求方法
        logger.setMethod(request.getMethod());
        //设置请求类型(json||普通请求)
        logger.setType(LoggerUtils.getRequestType(request));
        //设置请求参数内容json字符串
        logger.setParamData(paramData);
        //设置请求地址
        logger.setUri(url);
        //设置sessionID
        logger.setSessionId(sessionId);
        //设置请求开始的时间
        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
        //设置请求实体到request内，方便afterCompletion 方法调用
        request.setAttribute(LOGGER_ENTITY,logger);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        //获取请求错误码
        int status=response.getStatus();
        //当前时间
        long currentTime=System.currentTimeMillis();
        //请求开始的时间
        long time=Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        //获取本次请求的日志实体
       LoggerEntity loggerEntity=(LoggerEntity) request.getAttribute(LOGGER_ENTITY);
        //设置请求时间差
        loggerEntity.setTimeConsuming(Integer.valueOf((currentTime-time)+""));
        //设置返回的时间
        loggerEntity.setReturnTime(currentTime+"");
        //设置返回的错误码
        loggerEntity.setHttpStatusCode(status+"");
        //设置返回值
        loggerEntity.setReturnData(JSON.toJSONString(request.getAttribute(LoggerUtils.LOGGER_RETURN),SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteMapNullValue));
        //执行将日志写入数据库
        LoggerJPA loggerDAO=getDAO(LoggerJPA.class,request);
        loggerDAO.save(loggerEntity);

    }

    /**
     * 获取spring管理的bean
     * @param clazz
     * @param request
     * @param <T>
     * @return
     */
    private<T>T getDAO(Class<T> clazz,HttpServletRequest request){
        BeanFactory factory= WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);

    }
}
