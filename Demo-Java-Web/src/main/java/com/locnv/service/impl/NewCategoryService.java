package com.locnv.service.impl;

import com.locnv.Model.NewCategory;
import com.locnv.dao.INewCategoryDAO;
import com.locnv.service.INewCategoryService;

import javax.inject.Inject;
import java.util.List;

public class NewCategoryService implements INewCategoryService {
    @Inject
    private INewCategoryDAO newCategoryDAO;
    @Override
    public List<NewCategory> findAll() {
        return newCategoryDAO.findAll();
    }

    @Override
    public List<NewCategory> findRange(NewCategory newcate) {
        return newCategoryDAO.findRange(newcate.getPage(),newcate.getItems());
    }

    @Override
    public int getTotalItem() {
        return newCategoryDAO.getTotalItem();
    }

    @Override
    public NewCategory findByID(Long id) {
        return newCategoryDAO.findByID(id);
    }

    @Override
    public NewCategory add(NewCategory newCategory) {
        long id = newCategoryDAO.add(newCategory);
        return newCategoryDAO.findByID(id);
    }

    @Override
    public Boolean delete(Long id) {
        return newCategoryDAO.delete(id);
    }

    @Override
    public Boolean update(NewCategory newCategory) {
        return newCategoryDAO.update(newCategory);
    }
}
