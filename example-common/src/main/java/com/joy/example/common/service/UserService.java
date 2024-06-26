package com.joy.example.common.service;

import com.joy.example.common.model.User;

public interface UserService {
    /**
     * 获取用户
     * @param user
     * @return
     */
    User getUser(User user);

    /**
     * 新方法 - 获取数字
     * @return
     */
    default short getNumber() {
        return 1;
    }
}
