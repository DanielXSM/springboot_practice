package com.gupao.springbootjsp.mail;

import com.gupao.springbootjsp.model.MailEntity;
import com.gupao.springbootjsp.util.PropertiesUtil;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @program: spring-boot-jsp
 * @description:邮件发送者实体
 * @author:Daniel.zhao
 * @create:2018-04-25 10:14
 **/
public class MailSender {
    //邮件实体
    public static MailEntity mail = new MailEntity();

    /**
     * 设置邮件的标题
     *
     * @param title
     * @return
     */
    public MailSender title(String title) {
        mail.setTitle(title);
        return this;
    }

    /**
     * 设置邮件的内容
     *
     * @return
     */
    public MailSender content(String content) {
        mail.setContent(content);
        return this;
    }

    /**
     * 设置邮件的格式
     *
     * @return
     */
    public MailSender contentType(MailContentTypeEnum typeEnum) {
        mail.setContent(typeEnum.getValue());
        return this;
    }


    /**
     * 设置请求目标邮件的地址
     *
     * @return
     */
    public MailSender targets(List<String> targets) {
        mail.setList(targets);
        return this;
    }

    /**
     * 执行发送邮件
     *
     * @return
     */
    public void send() throws Exception {
        //默认使用html方式发送
        if (mail.getContentType() == null) {
            mail.setContentType(MailContentTypeEnum.HTML.getValue());
        }
        if (mail.getTitle() == null || mail.getTitle().trim().length() == 0) {
            throw new Exception("邮件标题没有设置,调用title方法设置");
        }
        if (mail.getContent() == null || mail.getContent().trim().length() == 0) {
            throw new Exception("邮件内容没有设置,调用content方法设置");
        }
        if (mail.getList().size() == 0) {
            throw new Exception("没有接受着的邮箱的地址，调用targets方法设置");
        }
        //读取/resource/mail_zh_CN_properties 文件的内容
        final PropertiesUtil properties = new PropertiesUtil("mail");
        //创建Properties 类用于记录邮箱的一些属性
        final Properties props = new Properties();
        //表示SMTP发送邮件,必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", properties.getValue("mail.smtp.service"));
        //设置端口号,QQ邮箱给出了两个端口465/587
        props.put("mail.smtp.port", properties.getValue("mail.smtp.port"));
        //设置发送邮箱
        props.put("mail.user", properties.getValue("mail.from.address"));
        //设置发送邮箱的16位SMTP口令
        props.put("mail.password", properties.getValue("mail.from.smtp.pwd"));
        //构建授权信息,用于进行SMTP进行身份验证
        Authenticator authenticators = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //用户名，密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                /*return super.getPasswordAuthentication();*/
                return new PasswordAuthentication(userName, password);
            }
        };

        //使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticators);
        //创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        //设置发件人
        String nickName = MimeUtility.encodeText(properties.getValue("mail.from.nickname"));
        InternetAddress form = new InternetAddress(nickName + "<" + props.getProperty("mail.user") + ">");
        message.setFrom(form);
        //设置邮件的标题
        message.setSubject(mail.getTitle());
        //html发送邮件
        if (mail.getContentType().equals(MailContentTypeEnum.HTML.getValue())) {
            //设置邮件的内容体
            message.setContent(mail.getContent(), mail.getContentType());
        }
        //文本邮件
        else if (mail.getContentType().equals(MailContentTypeEnum.TEXT.getValue())) {
            message.setText(mail.getContent());
        }
        //发送邮箱地址
        List<String> targets = mail.getList();
        for (int i = 0; i < targets.size(); i++) {
            try {
                //设置收件人的邮箱
                InternetAddress to = new InternetAddress(targets.get(i));
                message.setRecipient(Message.RecipientType.TO, to);
                //最后当然就是发送邮件拉
                Transport.send(message);
            } catch (Exception e) {
                continue;
            }
        }


    }

    public static void main(String[] args) {
        try {
            new MailSender().title("测试springboot发送邮件").content("简单文本内容发送").
                    contentType(MailContentTypeEnum.TEXT).targets(new ArrayList<String>() {
                {
                    add("qingt1009@vip.qq.com");
                }

            }).send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}