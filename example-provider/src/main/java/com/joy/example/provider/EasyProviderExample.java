package com.joy.example.provider;

import com.joy.example.common.service.UserService;
import com.joy.joyrpc.registry.LocalRegistry;
import com.joy.joyrpc.server.HttpServer;
import com.joy.joyrpc.server.VertxHttpServer;

/**
 * @author 杨世博
 * @date 2024/6/3 16:59
 * @description 简易服务提供者示例
 */
public class EasyProviderExample {
    public static void main(String[] args) {
        // 提供服务
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
