package com.joy.joyrpc.utils;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

import java.net.URL;

/**
 * @author 杨世博
 * @date 2024/6/4 21:03
 * @description 配置工具类
 */
public class ConfigUtils {
    /**
     * 加载配置对象
     *
     * @param tClass
     * @param prefix
     * @return
     * @param <T>
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix){
        return loadConfig(tClass, prefix, "");
    }

    /**
     * 加载配置对象，支持分区环境
     *
     * @param tClass
     * @param prefix
     * @param environment
     * @return
     * @param <T>
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix, String environment){
        StringBuilder configFileBuilder = new StringBuilder("application");
        if (StrUtil.isNotBlank(environment)) {
            configFileBuilder.append("-").append(environment);
        }
        if (resourceExists(configFileBuilder + ".yml")) {
            configFileBuilder.append(".yml");
        }else if (resourceExists(configFileBuilder + ".properties")) {
            configFileBuilder.append(".properties");
        }else if (resourceExists(configFileBuilder + ".yaml")) {
            configFileBuilder.append(".yaml");
        }
        Props props = new Props(configFileBuilder.toString(), "UTF-8");
        props.autoLoad(true);
        return props.toBean(tClass, prefix);
    }

    public static boolean resourceExists(String resourcePath){
        ClassLoader classLoader = ResourceUtil.class.getClassLoader();
        URL resourceUrl = classLoader.getResource(resourcePath);
        return resourceUrl != null;
    }
}
