package com.locnv.service.impl;

import com.locnv.Model.User;
import com.locnv.dao.IUserDAO;
import com.locnv.service.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService {
    @Inject
    private IUserDAO userDAO;
    @Override
    public User findUser(String username, String password, Integer status) {
        return userDAO.findUser(username,password,status);
    }

    @Override
    public User add(User user) {
        long id = userDAO.add(user);
        return userDAO.finUserById(id);
    }

    @Override
    public User findUserByUserName(String username) {
        return userDAO.findUserByUserName(username);
    }

    @Override
    public User findUserByID(Long id) {
        return userDAO.finUserById(id);
    }

    @Override
    public Boolean changeStatus(User user) {
        return userDAO.changeStatus(user);
    }

    @Override
    public Boolean updateUserInfor(User user) {
        return userDAO.updateUserInfor(user);
    }
}
