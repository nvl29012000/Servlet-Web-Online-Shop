package com.locnv.service.impl;

import com.locnv.Model.ProductCategory;
import com.locnv.dao.IProductCategoryDAO;
import com.locnv.service.IProductCategoryService;

import javax.inject.Inject;
import java.util.List;

public class ProductCategoryService implements IProductCategoryService {
    @Inject
    private IProductCategoryDAO productCategoryDAO;

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDAO.findAll();
    }

    @Override
    public List<ProductCategory> findRange(ProductCategory newcate) {
        return productCategoryDAO.findRang(newcate.getPage(),newcate.getItems());
    }

    @Override
    public int getTotalItem() {
        return productCategoryDAO.getToTalItem();
    }

    @Override
    public ProductCategory findByID(Long id) {
        return productCategoryDAO.findByID(id);
    }

    @Override
    public ProductCategory add(ProductCategory newcate) {
        long id = productCategoryDAO.add(newcate);
        return productCategoryDAO.findByID(id);
    }

    @Override
    public Boolean update(ProductCategory productCategory) {
        return productCategoryDAO.update(productCategory);
    }

    @Override
    public Boolean delete(Long id) {
        return productCategoryDAO.delete(id);
    }
}
