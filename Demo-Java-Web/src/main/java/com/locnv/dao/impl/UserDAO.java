package com.locnv.dao.impl;

import com.locnv.Map.UserMapper;
import com.locnv.Model.User;
import com.locnv.dao.IUserDAO;

import java.util.List;

public class UserDAO extends CommonDAO<User> implements IUserDAO {
    @Override
    public User findUser(String username, String password, Integer status) {
        StringBuilder sql = new StringBuilder("select * from dbo.Users where UserName = ? and Password = ? ");
        if(status != null)
            sql.append(" and Status = ?");
        List<User> users = execute(sql.toString(), new UserMapper(),username,password,status);
        return users.isEmpty()? null : users.get(0);
    }

    @Override
    public User finUserById(Long id) {
        String sql = "Select * from dbo.Users where ID = ? ";
        List<User> users = execute(sql,new UserMapper(), id);
        return users.isEmpty()? null : users.get(0);
    }

    @Override
    public User findUserByUserName(String username) {
        String sql = "Select * from dbo.Users where UserName = ?";
        List<User> users = execute(sql,new UserMapper(), username);
        return users.isEmpty()? null : users.get(0);
    }

    @Override
    public Long add(User user) {
        String sql = "insert into dbo.Users values(?,?,?,?,?,?,?)";
        return insert(sql, user.getUserName(),user.getPassword(),user.getName(),user.getPhone(),user.getEmail(),user.getAddress(),user.isStatus());
    }

    @Override
    public Boolean changeStatus(User user) {
        String sql = "update dbo.Users set Status = abs(status - 1) where id = ?";
        return update(sql, user.getID());
    }

    @Override
    public Boolean updateUserInfor(User user) {
        String sql = "Update dbo.Users set Name = ?, Phone = ?, Address = ?, Email = ? Where ID = ?";
        return update(sql,user.getName(),user.getPhone(),user.getAddress(),user.getEmail(),user.getID());
    }
}
