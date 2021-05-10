package com.locnv.dao.impl;

import com.locnv.Map.ProductMapper;
import com.locnv.Model.Product;
import com.locnv.dao.IProductDAO;

import java.util.List;

public class ProductDAO extends CommonDAO<Product> implements IProductDAO {
    @Override
    public List<Product> findAll() {
        String sql = "Select * from dbo.Product";
        return execute(sql, new ProductMapper());
    }

    @Override
    public List<Product> findRange(int page, int items) {
        String sql = new StringBuilder().append("SELECT * FROM\n")
                .append("(SELECT ROW_NUMBER() OVER(ORDER BY ID) AS RowNum, * FROM dbo.Product) AS alias\n")
                .append("WHERE RowNum BETWEEN ? AND ?").toString();
        int from = (page - 1) * items + 1;
        int to = page * items;
        return execute(sql, new ProductMapper(), from, to);
    }

    @Override
    public List<Product> findTop(int top,String orderBy, String orderType) {
        String sql = new StringBuilder("Select top("+ top +") * from Product ").append(" order by "+ orderBy +" ")
                .append(" "+ orderType +" ").toString();
        return execute(sql, new ProductMapper());
    }

    @Override
    public List<Product> findByCategoryID(Long id) {
        String sql = "Select * from dbo.Product Where CategoryID = ?";
        return execute(sql, new ProductMapper(), id);
    }

    @Override
    public int getTotalItem() {
        String sqlcount = "Select count(*) from dbo.Product";
        return countItem(sqlcount);
    }

    @Override
    public Product findByID(Long id) {
        String sql = "Select * from dbo.Product where ID = ?";
        List<Product> products = execute(sql, new ProductMapper(), id);
        return products.isEmpty() ? null : products.get(0);
    }

    @Override
    public Long add(Product product) {
        String sql = "Insert into dbo.Product values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return insert(sql, product.getName(), product.getProductCode(), product.getTitle(), product.getDescription(),
                product.getImage(), product.getPrice(), product.getSalePrice(), product.getQuantity(), product.getCategoryID(),
                product.getProductDetail(), product.getSaleDate(), product.getCreatedDate(), product.getCreatedBy(),
                product.getModifiedDate(), product.getModifiedBy(),
                product.getMetaKeyword(), product.getMetaDescription(), product.getViews(), product.isStatus());
    }

    @Override
    public Boolean update(Product product) {
        String sql = new StringBuilder().append("Update Product set Name = ? ,").append("ProductCode = ? ,")
                .append("Title = ? ,").append("Description = ? ,").append("Image = ? ,").append("Price = ? ,")
                .append("SalePrice = ? ,").append("Quantity = ? ,").append("CategoryID = ? ,").append("ProductDetail = ? ,")
                .append("SaleDate = ? ,").append("ModifiedDate = ? ,").append("ModifiedBy = ? ,").append("MetaKeyword = ? ,")
                .append("MetaDescription = ? ,").append("Status = ? ").append("Where ID = ?").toString();
        return update(sql, product.getName(), product.getProductCode(), product.getTitle(), product.getDescription(),
                product.getImage(), product.getPrice(), product.getSalePrice(), product.getQuantity(), product.getCategoryID(),
                product.getProductDetail(), product.getSaleDate(), product.getModifiedDate(), product.getModifiedBy(),
                product.getMetaKeyword(), product.getMetaDescription(), product.isStatus(), product.getID());

    }

    @Override
    public Boolean delete(long id) {
        String sql = "Delete from Product Where ID = ?";
        return update(sql,id);
    }
}
