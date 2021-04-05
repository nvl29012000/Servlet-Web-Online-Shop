package com.locnv.service.impl;

import com.locnv.Model.AdminUser;
import com.locnv.dao.IAdminUserDAO;
import com.locnv.service.IAdminUserService;

import javax.inject.Inject;
import java.util.List;

public class AdminUserService implements IAdminUserService {
    @Inject
    private IAdminUserDAO adminUserDAO;
    @Override
    public List<AdminUser> findAll() {
        return adminUserDAO.findAll();
    }

    @Override
    public AdminUser findUser(String username, String password, Integer status) {
        return adminUserDAO.findUser(username,password,status);
    }

    @Override
    public Boolean changeStatus(AdminUser user) {
        return adminUserDAO.changeStatus(user);
    }

    @Override
    public AdminUser findUserByID(Long id) {
        return adminUserDAO.finUserByID(id);
    }

    @Override
    public AdminUser findUserByUserName(String username) {
        return adminUserDAO.finUserByUserName(username);
    }

    @Override
    public AdminUser add(AdminUser adminUser) {
        long id = adminUserDAO.add(adminUser);
        return adminUserDAO.finUserByID(id);
    }
}
