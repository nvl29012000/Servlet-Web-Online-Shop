package com.locnv.service;

import com.locnv.Model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    List<Product> findRange(Product product);
    int getTotalItem();
}
