package com.locnv.Map;

import com.locnv.Model.Menu;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuMapper implements Mapper<Menu> {
    @Override
    public Menu mapRowtoObj(ResultSet rs) {
        try{
            Menu menu = new Menu();
            menu.setID(rs.getLong("ID"));
            menu.setText(rs.getString("Text"));
            menu.setLink(rs.getString("Link"));
            menu.setDisplayOrder(rs.getInt("DisplayOrder"));
            menu.setTarget(rs.getString("Target"));
            menu.setStatus(rs.getBoolean("Status"));
            menu.setMenuTypeID(rs.getLong("MenuTypeID"));
            return menu;
        }catch (SQLException e){
            return null;
        }
    }
}
