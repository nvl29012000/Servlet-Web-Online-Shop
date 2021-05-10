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
    public List<Product> findTop(int top, String orderBy, String orderType) {
        return productDAO.findTop(top,orderBy,orderType);
    }

    @Override
    public List<Product> findByCategoryID(Long id) {
        return productDAO.findByCategoryID(id);
    }

    @Override
    public int getTotalItem() {
        return productDAO.getTotalItem();
    }

    @Override
    public Product findByID(Long id) {
        return productDAO.findByID(id);
    }

    @Override
    public Product add(Product product) {
        long id = productDAO.add(product);
        return productDAO.findByID(id);
    }

    @Override
    public Boolean update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public Boolean delete(Long id) {
        return productDAO.delete(id);
    }
}
