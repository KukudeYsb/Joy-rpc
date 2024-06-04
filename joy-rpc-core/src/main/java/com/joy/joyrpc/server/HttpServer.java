package com.joy.joyrpc.server;

/**
 * @author 杨世博
 * @date 2024/6/3 17:11
 * @description HTTP 服务器接口
 */
public interface HttpServer {
    /**
     * 启动服务器
     *
     * @param port
     */
    void doStart(int port);
}
