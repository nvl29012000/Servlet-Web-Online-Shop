package com.locnv.service;

import com.locnv.Model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    List<Product> findRange(Product product);
    List<Product> findTop(int top, String orderBy, String orderType);
    List<Product> findByCategoryID(Long id);
    int getTotalItem();
    Product findByID(Long id);
    Product add(Product product);
    Boolean update(Product product);
    Boolean delete(Long id);
}
