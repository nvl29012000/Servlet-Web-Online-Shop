package com.locnv.service;

import com.locnv.Model.NewCategory;

import java.util.List;

public interface INewCategoryService {
    List<NewCategory> findAll();
    List<NewCategory> findRange(NewCategory newcate);
    int getTotalItem();
    NewCategory findByID(Long id);
    NewCategory add(NewCategory newCategory);
    Boolean delete(Long id);
    Boolean update(NewCategory newCategory);
}
