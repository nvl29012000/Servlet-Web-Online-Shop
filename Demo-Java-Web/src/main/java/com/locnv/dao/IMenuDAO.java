package com.locnv.dao;

import com.locnv.Model.Menu;

import java.util.List;

public interface IMenuDAO extends IGenericDAO<Menu> {
    List<Menu> findByMenuType(Long menuType);
}
