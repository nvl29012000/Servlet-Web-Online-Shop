package com.locnv.service;

import com.locnv.Model.Menu;

import java.util.List;

public interface IMenuService {
    List<Menu> findByMenuType(Long menyType);
}
