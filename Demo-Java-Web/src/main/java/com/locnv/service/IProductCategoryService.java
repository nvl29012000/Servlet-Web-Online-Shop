package com.locnv.service;

import com.locnv.Model.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    List<ProductCategory> findAll();
    List<ProductCategory> findRange(ProductCategory newcate);
    int getTotalItem();
    ProductCategory findByID(Long id);
    ProductCategory add(ProductCategory newcate);
    Boolean update(ProductCategory productCategory);
    Boolean delete(Long id);
}
