package com.gupao.springbootjsp.model;

import java.io.Serializable;

/**
 * @program: spring-boot-jsp
 * @description:邮件entity
 * @author:Daniel.zhao
 * @create:2018-04-24 21:13
 **/
public class MailEntity implements Serializable{


    private static final long serialVersionUID = 4743316105564087603L;

    //此处填写SMTP服务器
    private String smtpService;
    //设置端口号
    private String smtpPort;
    //设置发送邮件
    private String fromMailAddress;
    //设置发送邮箱

}
