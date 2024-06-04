package com.joy.joyrpc.config;

import com.joy.joyrpc.serializer.SerializerKeys;
import lombok.Data;

/**
 * @author 杨世博
 * @date 2024/6/4 20:47
 * @description RPC 框架配置
 */
@Data
public class RpcConfig {

    /**
     * 模拟调用
     */
    private boolean mock = false;

    /**
     * 名称
     */
    private String name = "joy-rpc";

    /**
     * 版本号
     */
    private String version = "1.0";

    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";

    /**
     * 服务器端口号
     */
    private Integer serverPort = 8080;

    /**
     * 序列化器
     */
    private String serializer = SerializerKeys.JDK;
}
