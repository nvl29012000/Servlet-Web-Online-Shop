package com.locnv.dao.impl;

import com.locnv.Map.NewCategoryMapper;
import com.locnv.Model.NewCategory;
import com.locnv.dao.INewCategoryDAO;

import java.util.List;

public class NewCategoryDAO extends CommonDAO<NewCategory> implements INewCategoryDAO {
    @Override
    public List<NewCategory> findAll() {
        String sql = "Select * from dbo.NewCategory";
        return execute(sql, new NewCategoryMapper());
    }

    @Override
    public List<NewCategory> findRange(int page, int items) {
        String sql = new StringBuilder().append("SELECT * FROM\n")
                .append("(SELECT ROW_NUMBER() OVER(ORDER BY ID) AS RowNum, * FROM dbo.NewCategory) AS alias\n")
                .append("WHERE RowNum BETWEEN ? AND ?").toString();
        int from = (page - 1) * items + 1;
        int to = page * items;
        return execute(sql, new NewCategoryMapper(), from, to);
    }

    @Override
    public int getTotalItem() {
        String sqlcount = "Select count(*) from dbo.NewCategory";
        return countItem(sqlcount);
    }

    @Override
    public Long add(NewCategory newCategory) {
        String sql = "Insert into dbo.NewCategory values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return insert(sql,newCategory.getName(),newCategory.getTitle(),newCategory.getParentID(),
                newCategory.getDisplayOrder(),newCategory.getSeoTitle(),newCategory.getCreatedDate(),
                newCategory.getCreatedBy(),newCategory.getModifiedDate(),newCategory.getModifiedBy(),
                newCategory.getMetaKeyword(), newCategory.getMetaDescription(),
                newCategory.isShowOnHome(),newCategory.isStatus());
    }

    @Override
    public NewCategory findByID(Long id) {
        String sql = "Select * from dbo.NewCategory where ID = ?";
        List<NewCategory> newCategories = execute(sql,new NewCategoryMapper(),id);
        return newCategories.isEmpty() ? null : newCategories.get(0);
    }

    @Override
    public Boolean delete(Long id) {
        String sql = "Delete from dbo.NewCategory where ID = ?";
        return update(sql,id);
    }

    @Override
    public Boolean update(NewCategory newCategory) {
        String sql = new StringBuilder().append("Update NewCategory ").append(" set Name = ?, ")
                .append("Title = ?, ").append("ParentID = ?, ").append("DisplayOrder = ?, ")
                .append("SeoTitle = ?, ").append("ModifiedDate = ?, ").append("ModifiedBy = ?, ")
                .append("MetaKeyword = ?, ").append("MetaDescription = ?, ").append("ShowOnHome = ?, ")
                .append("Status = ? ").append("where ID = ?").toString();
        return update(sql, newCategory.getName(),newCategory.getTitle(),newCategory.getParentID(),
                newCategory.getDisplayOrder(),newCategory.getSeoTitle(),newCategory.getModifiedDate(),
                newCategory.getModifiedBy(),newCategory.getMetaKeyword(),newCategory.getMetaDescription(),
                newCategory.isShowOnHome(),newCategory.isStatus(),newCategory.getID());
    }
}
