package com.joy.example.provider;

import com.joy.example.common.model.User;
import com.joy.example.common.service.UserService;

/**
 * @author 杨世博
 * @date 2024/6/3 16:55
 * @description 用户服务实现类
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
