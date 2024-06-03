package com.joy.example.consumer;

import cn.hutool.db.Page;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.server.HttpServerResponse;
import com.joy.example.common.model.User;
import com.joy.example.common.service.UserService;
import com.joy.joyrpc.model.RpcRequest;
import com.joy.joyrpc.model.RpcResponse;
import com.joy.joyrpc.serializer.JdkSerialize;
import com.joy.joyrpc.serializer.Serializer;

import java.io.IOException;

/**
 * @author 杨世博
 * @date 2024/6/3 21:32
 * @description 服务代理
 */
public class UserServiceProxy implements UserService {
    @Override
    public User getUser(User user) {
        // 指定序列化器
        Serializer serializer = new JdkSerialize();

        // 发请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}