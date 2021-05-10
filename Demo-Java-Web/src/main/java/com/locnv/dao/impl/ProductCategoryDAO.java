package com.locnv.dao.impl;

import com.locnv.Map.ProductCategoryMapper;
import com.locnv.Model.ProductCategory;
import com.locnv.dao.IProductCategoryDAO;

import java.util.List;

public class ProductCategoryDAO extends CommonDAO<ProductCategory> implements IProductCategoryDAO {

    @Override
    public List<ProductCategory> findAll() {
        String sql = "Select * from dbo.ProductCategory";
        return execute(sql, new ProductCategoryMapper());
    }

    @Override
    public List<ProductCategory> findRang(int page, int items) {
        String sql = new StringBuilder().append("SELECT * FROM\n")
                .append("(SELECT ROW_NUMBER() OVER(ORDER BY ID) AS RowNum, * FROM dbo.ProductCategory) AS alias\n")
                .append("WHERE RowNum BETWEEN ? AND ?").toString();
        int from = (page - 1) * items + 1;
        int to = page * items;
        return execute(sql, new ProductCategoryMapper(), from, to);
    }

    @Override
    public int getToTalItem() {
        String sqlcount = "Select count(*) from dbo.ProductCategory";
        return countItem(sqlcount);
    }

    @Override
    public Long add(ProductCategory productCategory) {
        String sql = "Insert into ProductCategory values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return insert(sql,productCategory.getName(),productCategory.getTitle(),productCategory.getParentID(),
                productCategory.getDisplayOrder(),productCategory.getSeoTitle(),productCategory.getCreatedDate(),
                productCategory.getCreatedBy(),productCategory.getModifiedDate(),productCategory.getModifiedBy(),
                productCategory.getMetaKeyword(), productCategory.getMetaDescription(),
                productCategory.isShowOnHome(),productCategory.isStatus(),productCategory.getImage());
    }

    @Override
    public Boolean update(ProductCategory productCategory) {
        String sql = new StringBuilder().append("Update ProductCategory").append(" set Name = ?, ")
                .append("Title = ?, ").append("ParentID = ?, ").append("DisplayOrder = ?, ")
                .append("SeoTitle = ?, ").append("ModifiedDate = ?, ").append("ModifiedBy = ?, ")
                .append("MetaKeyword = ?, ").append("MetaDescription = ?, ").append("ShowOnHome = ?, ")
                .append("Status = ? ,").append(" Image = ? ").append("where ID = ?").toString();
        return update(sql,productCategory.getName(),productCategory.getTitle(),productCategory.getParentID(),
                productCategory.getDisplayOrder(),productCategory.getSeoTitle(),productCategory.getModifiedDate(),
                productCategory.getModifiedBy(),productCategory.getMetaKeyword(),productCategory.getMetaDescription(),
                productCategory.isShowOnHome(),productCategory.isStatus(),productCategory.getImage(),productCategory.getID());
    }

    @Override
    public ProductCategory findByID(Long id) {
        String sql = "Select * from dbo.ProductCategory where ID = ?";
        List<ProductCategory> productCategory = execute(sql,new ProductCategoryMapper(),id);
        return productCategory.isEmpty() ? null : productCategory.get(0);
    }

    @Override
    public Boolean delete(long id) {
        String sql = "Delete from dbo.ProductCategory where ID = ?";
        return update(sql,id);
    }
}
