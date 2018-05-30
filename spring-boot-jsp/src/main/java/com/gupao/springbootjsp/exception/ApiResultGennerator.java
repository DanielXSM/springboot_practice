package com.gupao.springbootjsp.exception;

import java.util.List;

/**
 * @program: spring-boot-jsp
 * @description:该类是用来创建成功、失败返回JSON的工具类
 * @author:Daniel.zhao
 * @create:2018-05-30 17:47
 **/
public class ApiResultGennerator {

    public static  ApiResult result(boolean flag,String msg,Object result,String jumpUrl,int rows,Throwable throwable){

        //创建返回的对象
        ApiResult apiResult=ApiResult.newInstance();

        apiResult.setFlag(flag);
        apiResult.setMsg(msg==""?"执行成功":msg);
        apiResult.setResult(result);
        apiResult.setJumpUrl(jumpUrl);
        apiResult.setTime(System.currentTimeMillis());
        apiResult.setRows(rows);
        return apiResult;
    }


    public static  ApiResult successResult(Object result){
        //rows 默认为0
        int rows=0;
        //如果是集合
        if(result instanceof List){
            //获取总数量
            rows =((List)result).size();
        }
        return result(true,"",result,"",rows,null);
    }

    /**
     * 执行失败后返回视图方法
     * @return 执行失败后的错误消息内容
     */
    public static ApiResult errorResult(String msg,Throwable throwable){
        return result(false,msg,"","/errors",0,throwable);
    }

}
