package com.gupao.springbootjsp.exception;

import java.io.Serializable;

/**
 * @program: spring-boot-jsp
 * @description:异常返回的实体
 * @author:Daniel.zhao
 * @create:2018-05-30 17:20
 **/


/**
 * 我们将这个类的构造函数私有化了，所以我们在外部不能直接使用new的方式创建对象，我们提供了一个newInstace方法来实例化ApiResult并获取对象
 * 。下面我们创建一个ApiResultGenerator用来生成ApiResult不同状态的返回内容（成功、失败）。
 */
public class ApiResult implements Serializable {

//私有化构造方法
    private ApiResult(){}


    public static  ApiResult newInstance(){
        return new ApiResult();
    }

    //消息的提示
    private String msg;

    //状态信息

    private boolean flag=true;


    //返回的结构

    private  Object result;


    //查询出的结构总数

    private int rows;

    //需要跳转的路径

    private String jumpUrl;

    //接口的响应时间 ，单位是毫秒

    private Long time;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
