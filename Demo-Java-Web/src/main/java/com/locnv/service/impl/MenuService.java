package com.locnv.service.impl;

import com.locnv.Model.Menu;
import com.locnv.dao.IMenuDAO;
import com.locnv.service.IMenuService;

import javax.inject.Inject;
import java.util.List;

public class MenuService implements IMenuService {
    @Inject
    private IMenuDAO menuDAO;
    @Override
    public List<Menu> findByMenuType(Long menyType) {
        return menuDAO.findByMenuType(menyType);
    }
}
