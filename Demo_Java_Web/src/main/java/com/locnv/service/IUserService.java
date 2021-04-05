package com.locnv.service;

import com.locnv.Model.User;

public interface IUserService {
    User findUser(String username, String password, Integer status);
    User add(User user);
    User findUserByUserName(String username);
    User findUserByID(Long id);
    Boolean changeStatus(User user);
}
