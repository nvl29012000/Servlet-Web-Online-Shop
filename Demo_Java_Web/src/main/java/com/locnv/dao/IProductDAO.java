package com.locnv.dao;

import com.locnv.Model.New;
import com.locnv.Model.Product;

import java.util.List;

public interface IProductDAO extends IGenericDAO<Product>{
    List<Product> findAll();
    List<Product> findRange(int page, int items);
    int getTotalItem();
}
