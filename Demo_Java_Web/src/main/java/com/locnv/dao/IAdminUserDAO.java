package com.locnv.dao;

import com.locnv.Model.AdminUser;

import java.util.List;

public interface IAdminUserDAO extends IGenericDAO<AdminUser> {
    List<AdminUser> findAll();
    AdminUser findUser(String username, String password, Integer status);
    Boolean changeStatus(AdminUser user);
    AdminUser finUserByID(Long id);
    AdminUser finUserByUserName(String username);
    Long add(AdminUser adminUser);
}
