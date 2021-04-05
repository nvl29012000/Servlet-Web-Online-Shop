package com.locnv.service;

import com.locnv.Model.NewCategory;

import java.util.List;

public interface INewCategoryService {
    List<NewCategory> findAll();
    List<NewCategory> findRange(NewCategory newcate);
    int getTotalItem();
}
