package com.locnv.Map;

import com.locnv.Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    @Override
    public User mapRowtoObj(ResultSet rs) {
        try{
            User user = new User();
            user.setID(rs.getLong("ID"));
            user.setUserName(rs.getString("UserName"));
            user.setPassword(rs.getString("Password"));
            user.setName(rs.getString("Name"));
            user.setPhone(rs.getString("Phone"));
            user.setAddress(rs.getString("Address"));
            user.setEmail(rs.getString("Email"));
            user.setStatus(rs.getBoolean("Status"));
            return user;
        }catch (SQLException e){
            return null;
        }
    }
}
