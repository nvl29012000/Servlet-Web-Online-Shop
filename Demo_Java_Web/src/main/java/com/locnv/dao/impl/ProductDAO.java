package com.locnv.dao.impl;

import com.locnv.Map.ProductMapper;
import com.locnv.Model.Product;
import com.locnv.dao.IProductDAO;

import java.util.List;

public class ProductDAO extends CommonDAO<Product> implements IProductDAO {
    @Override
    public List<Product> findAll() {
        String sql = "Select * from dbo.Product";
        return execute(sql,new ProductMapper());
    }

    @Override
    public List<Product> findRange(int page, int items) {
        String sql = new StringBuilder().append("SELECT * FROM\n")
                .append("(SELECT ROW_NUMBER() OVER(ORDER BY ID) AS RowNum, * FROM dbo.Product) AS alias\n")
                .append("WHERE RowNum BETWEEN ? AND ?").toString();
        int from = (page-1) * items + 1;
        int to = page * items;
        return execute(sql,new ProductMapper(),from,to);
    }

    @Override
    public int getTotalItem() {
        String sqlcount = "Select count(*) from dbo.Product";
        return countItem(sqlcount);
    }
}
