package com.gupao.springbootjsp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.security.Timestamp;

/**
 * @program: spring-boot-jsp
 * @description:日志记录
 * @author:Daniel.zhao
 * @create:2018-04-28 16:58
 **/
@Entity
@Table(name="t_logger_infos")
public class LoggerEntity implements Serializable{

    private static final long serialVersionUID = -8394552577817461538L;

    //编号
    @Id
    @GeneratedValue
    @Column(name="ali_id")
    private Long id;
    //客户端请求ip
    @Column(name="ali_client_ip")
    private String clientip;
    //客户端请求路径
    @Column(name="ali_uri")
    private String uri;
    //终端请求方式，普通请求，ajax请求
    @Column(name="ali_type")
    private String type;
    //请求方式，method,post,get等
    @Column(name="ali_method")
    private String method;
    //请求参数内容 json
    @Column(name="ali_param_data")
    private String paramData;
    //请求接口唯一的标识sessionID
    @Column(name="ali_session_id")
    private String sessionId;
    //请求时间
    @Column(name="ali_time")
    private Timestamp time;
    //接口返回时间
    @Column(name="ali_return_time")
    private String returnTime;
    //接口返回数据json
    @Column(name="ali_return_data")
    private String returnData;
    @Column(name="ali_http_status_code")
    private String httpStatusCode;
    @Column(name="ali_time_consuming")
    private Integer timeConsuming;

    public Integer getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(Integer timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientip() {
        return clientip;
    }

    public void setClientip(String clientip) {
        this.clientip = clientip;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }
}
