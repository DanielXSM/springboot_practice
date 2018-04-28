package com.gupao.springbootjsp.util.aes;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bei2love@gmail.com on 15/5/15.
 */
public class PropertiesUtil {
    /**
     * 配置内部属性，默认缓存，支持重置
     */
    private static Map<String, String> cfgMap = new HashMap<String, String>();
    private static final String CONST_PROPERTIES_FILE_NAME = "classpath:aes/aes.config";

    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader propertiesLoader = null;


    /**
     * 初始化配置文件
     */
    public static void load() {
        if (cfgMap.size() == 0) {
            propertiesLoader = new PropertiesLoader(CONST_PROPERTIES_FILE_NAME);
        }
    }

    static {
        load();
    }

    /**
     * 重置配置文件（重新加载）
     */
    public static void reset() {
        cfgMap.clear();
        load();
    }

    /**
     * 获取配置
     */
    public static String getConfig(String key) {
        String value = cfgMap.get(key);
        if (value == null) {
            value = propertiesLoader.getProperty(key);
            cfgMap.put(key, value);
        }
        return value;
    }

    public static String getConfig(String key, String defaultVal){
        String value = getConfig(key);
        return StringUtils.isBlank(value) ? defaultVal : value;
    }
}
