package com.locnv.Map;

import com.locnv.Model.AdminUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminUserMapper implements Mapper<AdminUser>{

    @Override
    public AdminUser mapRowtoObj(ResultSet rs) {
        try{
            AdminUser user = new AdminUser();
            user.setID(rs.getLong("ID"));
            user.setUsername(rs.getString("Username"));
            user.setPassword(rs.getString("Password"));
            user.setStatus(rs.getBoolean("Status"));
            return user;
        }catch (SQLException e){
            return null;
        }
    }
}
