package com.joy.joyrpc;

import com.joy.joyrpc.config.RpcConfig;
import com.joy.joyrpc.content.RpcContent;
import com.joy.joyrpc.utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 杨世博
 * @date 2024/6/4 21:16
 * @description RPC 框架应用
 * 相当于 holder，存放了项目全局用到的变量。双检锁单例模式实现
 */
@Slf4j
public class RpcApplication {

    private static volatile RpcConfig rpcConfig;

    /**
     * 框架初始化，支持传入自定义配置
     * @param newRpcConfig
     */
    public static void init(RpcConfig newRpcConfig) {
        rpcConfig = newRpcConfig;
        log.info("rpc init,config = {}", newRpcConfig.toString());
    }

    /**
     * 初始化
     */
    public static void init() {
        RpcConfig newRpcConfig;
        try {
            newRpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcContent.DEFAULT_CONFIG_PREDIX);
        } catch (Exception e) {
            // 配置加载失败，使用默认值
            newRpcConfig = new RpcConfig();
            e.printStackTrace();
        }
        init(newRpcConfig);
    }

    /**
     * 获取配置
     * @return
     */
    public static RpcConfig getRpcConfig() {
        if (rpcConfig == null){
            synchronized (RpcApplication.class) {
                if (rpcConfig == null) {
                    init();
                }
            }
        }
        return rpcConfig;
    }
}
