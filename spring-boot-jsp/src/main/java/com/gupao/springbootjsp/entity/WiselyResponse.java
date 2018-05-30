package com.gupao.springbootjsp.entity;

/**
 * @program: spring-boot-jsp
 * @description:下面我们再来创建一个服务端广播通知浏览器的实体类型
 * @author:Daniel.zhao
 * @create:2018-05-30 10:42
 **/
public class WiselyResponse {
    private String responseMessage;


    public WiselyResponse(String responseMessage){
        this.responseMessage=responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
