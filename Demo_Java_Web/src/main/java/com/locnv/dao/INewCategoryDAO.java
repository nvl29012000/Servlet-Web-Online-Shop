package com.locnv.dao;

import com.locnv.Model.NewCategory;

import java.util.List;

public interface INewCategoryDAO extends IGenericDAO<NewCategory> {
    List<NewCategory> findAll();
    List<NewCategory> findRange(int page, int items);
    int getTotalItem();
    Long add(NewCategory newCategory);
}
