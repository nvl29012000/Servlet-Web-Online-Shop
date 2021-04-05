package com.locnv.dao;

import com.locnv.Model.ProductCategory;

import java.util.List;

public interface IProductCategoryDAO extends IGenericDAO<ProductCategory>{
    List<ProductCategory> findAll();
    List<ProductCategory> findRang(int page, int items);
    int getToTalItem();
    Long add(ProductCategory productCategory);
    Boolean update(ProductCategory productCategory);
    ProductCategory findByID(Long id);
    Boolean delete(long id);
}
