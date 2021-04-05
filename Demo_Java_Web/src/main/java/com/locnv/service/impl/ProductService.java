package com.locnv.service.impl;

import com.locnv.Model.Product;
import com.locnv.dao.IProductDAO;
import com.locnv.service.IProductService;

import javax.inject.Inject;
import java.util.List;

public class ProductService implements IProductService {
    @Inject
    private IProductDAO productDAO;
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<Product> findRange(Product product) {
        return productDAO.findRange(product.getPage(), product.getItems());
    }

    @Override
    public int getTotalItem() {
        return productDAO.getTotalItem();
    }
}
