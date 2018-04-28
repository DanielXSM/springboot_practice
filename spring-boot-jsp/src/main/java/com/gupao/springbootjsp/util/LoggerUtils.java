package com.gupao.springbootjsp.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: spring-boot-jsp
 * @description:日志收集工具
 * @author:Daniel.zhao
 * @create:2018-04-28 19:21
 **/
public class LoggerUtils {
    public static final String LOGGER_RETURN = "_logger_return";
    private LoggerUtils() {}

public static String getClientIp(HttpServletRequest request){
        String ip=request.getHeader("x-forwarded-for");
    if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getRemoteAddr();
    }
// 多个路由时，取第一个非unknown的ip
    final String[] arr = ip.split(",");
    for (final String str : arr) {
        if (!"unknown".equalsIgnoreCase(str)) {
            ip = str;
            break;
        }
    }
    return ip;

}


    /**
     * 判断是否为ajax请求
     * @param request
     * @return
     */
    public static String getRequestType(HttpServletRequest request) {
        return request.getHeader("X-Requested-With");
    }

}
