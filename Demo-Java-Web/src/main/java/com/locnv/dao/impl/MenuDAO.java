package com.locnv.dao.impl;

import com.locnv.Map.MenuMapper;
import com.locnv.Model.Menu;
import com.locnv.dao.IMenuDAO;

import java.util.List;

public class MenuDAO extends CommonDAO<Menu> implements IMenuDAO {
    @Override
    public List<Menu> findByMenuType(Long menuType) {
        String sql = "Select * from dbo.Menu where MenuTypeID = ?";
        return execute(sql, new MenuMapper(),menuType);
    }
}
