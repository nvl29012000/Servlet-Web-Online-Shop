package com.locnv.dao;

import com.locnv.Model.Product;

import java.util.List;

public interface IProductDAO extends IGenericDAO<Product>{
    List<Product> findAll();
    List<Product> findRange(int page, int items);
    List<Product> findTop(int top,String orderBy,String orderType);
    List<Product> findByCategoryID(Long id);
    int getTotalItem();
    Product findByID(Long id);
    Long add(Product product);
    Boolean update(Product product);
    Boolean delete(long id);
}
