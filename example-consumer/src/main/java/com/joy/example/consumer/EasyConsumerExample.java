package com.joy.example.consumer;

import com.joy.example.common.model.User;
import com.joy.example.common.service.UserService;
import com.joy.joyrpc.proxy.ServiceProxyFactory;

/**
 * @author 杨世博
 * @date 2024/6/3 17:01
 * @description 简易服务消费者示例
 */
public class EasyConsumerExample {
    public static void main(String[] args) {
        // todo 需要获取 UserService 的实现对象
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("joy");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        }else {
            System.out.println("user == null");
        }
    }
}
