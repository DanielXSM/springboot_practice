package com.gupao.springbootjsp.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @program: spring-boot-jsp
 * @description:加载配置文件的类
 * @author:Daniel.zhao
 * @create:2018-04-25 21:25
 **/
public class PropertiesUtil {
    private final ResourceBundle resource;
    private final String fileName;


    public PropertiesUtil(String fileName) {
        this.fileName = fileName;
        Locale locale=new Locale("zh","CN");
        this.resource=ResourceBundle.getBundle(this.fileName,locale);
    }

    public String getValue(String key){
        String message=this.resource.getString(key);
        return message;
    }



}
