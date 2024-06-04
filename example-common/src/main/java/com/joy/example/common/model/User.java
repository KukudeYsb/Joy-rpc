package com.joy.example.common.model;

import java.io.Serializable;

/**
 * @author 杨世博
 * @date 2024/6/3 16:34
 * @description 用户
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
