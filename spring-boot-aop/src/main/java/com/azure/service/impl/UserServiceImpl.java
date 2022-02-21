package com.azure.service.impl;

import com.azure.annotations.MyAdvice;
import com.azure.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String selectUser(String userName) {
        System.out.println("======selectUser======");
        return userName;
    }

    @Override
    @MyAdvice//自定义注解
    public void insertUser() {
        System.out.println("======insertUser======");
    }

    @Override
    public void updateUser() {
        System.out.println("updateUser");
    }

    @Override
    public void deleteUser() {
        System.out.println("deleteUser");
    }
}
