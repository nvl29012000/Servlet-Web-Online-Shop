package com.locnv.dao.impl;

import com.locnv.Map.AdminUserMapper;
import com.locnv.Map.UserMapper;
import com.locnv.Model.AdminUser;
import com.locnv.dao.IAdminUserDAO;

import java.util.List;

public class AdminUserDAO extends CommonDAO<AdminUser> implements IAdminUserDAO {
    @Override
    public List<AdminUser> findAll() {
        String sql = "Select * from dbo.AdminUser";
        return execute(sql, new AdminUserMapper());
    }

    @Override
    public AdminUser findUser(String username, String password, Integer status) {
        String sql = "select * from dbo.AdminUser where UserName = ? and Password = ? and Status = ?";
        List<AdminUser> users = execute(sql, new AdminUserMapper(),username,password,status);
        return users.isEmpty()? null : users.get(0);
    }

    @Override
    public Boolean changeStatus(AdminUser user) {
        String sql = "update dbo.AdminUser set Status = abs(status - 1) where id = ?";
        return update(sql, user.getID());
    }

    @Override
    public AdminUser finUserByID(Long id) {
        String sql = "Select * from dbo.AdminUser where ID = ? ";
        List<AdminUser> users = execute(sql,new AdminUserMapper(), id);
        return users.isEmpty()? null : users.get(0);
    }

    @Override
    public AdminUser finUserByUserName(String username) {
        String sql = "select * from dbo.AdminUser where UserName = ?";
        List<AdminUser> users = execute(sql, new AdminUserMapper(), username);
        return users.isEmpty()? null : users.get(0);
    }

    @Override
    public Long add(AdminUser adminUser) {
        String sql = "insert into dbo.AdminUser values (?,?,?)";
        return insert(sql,adminUser.getUsername(),adminUser.getPassword(),adminUser.isStatus());
    }
}
