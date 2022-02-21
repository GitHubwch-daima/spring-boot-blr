package com.azure.service;

public interface UserService {

    String selectUser(String userName);

    void insertUser();

    void updateUser();

    void deleteUser();
}
