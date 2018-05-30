package com.gupao.springbootjsp.exception;

import org.springframework.web.bind.annotation.*;

/**
 * @program: spring-boot-jsp
 * @description:统一的异常处理
 * @author:Daniel.zhao
 * @create:2018-05-30 16:57
 **/

/**
 * @ExceptionHandler注解用来配置需要拦截的异常类型，
 * 默认是全局类型。@ResponseStatus注解用于配置遇到该异常后返回数据时的StatusCode的值，
 * 我们这里默认使用值500。在类的上方我们配置了@ControllerAdvice的annotations属性值为RestController.class，
 * 也就是只有添加了@RestController注解的控制器才会进入全局异常处理，下面我们来添加一个测试控制器。

 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {
    /**
     * 默认统一异常的处理方法
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseStatus
    public ApiResult runtimeExceptionHandler(Exception e){
        return ApiResultGennerator.errorResult(e.getMessage(),e);
    }



}
