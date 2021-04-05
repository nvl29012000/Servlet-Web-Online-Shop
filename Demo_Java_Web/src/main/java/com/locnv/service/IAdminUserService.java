package com.locnv.service;

import com.locnv.Model.AdminUser;

import java.util.List;

public interface IAdminUserService {
    List<AdminUser> findAll();
    AdminUser findUser(String username, String password, Integer status);
    Boolean changeStatus(AdminUser user);
    AdminUser findUserByID(Long id);
    AdminUser findUserByUserName(String username);
    AdminUser add(AdminUser adminUser);
}
