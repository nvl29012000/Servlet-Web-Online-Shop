package com.locnv.dao.impl;

import com.locnv.Map.NewMapper;
import com.locnv.Model.New;
import com.locnv.dao.INewDAO;

import java.util.List;

public class NewDAO extends CommonDAO<New> implements INewDAO {
    @Override
    public List<New> findAll() {
        String sql = "select * from dbo.New";
        return execute(sql, new NewMapper());
    }

    @Override
    public List<New> findRange(int page, int items) {
        String sql = new StringBuilder().append("SELECT * FROM\n")
        .append("(SELECT ROW_NUMBER() OVER(ORDER BY ID) AS RowNum, * FROM dbo.New) AS alias\n")
        .append("WHERE RowNum BETWEEN ? AND ?").toString();
        int from = (page-1) * items + 1;
        int to = page * items;
        return execute(sql,new NewMapper(),from,to);
    }

    @Override
    public List<New> findByCategoryID(Long categoryID) {
        String sql = "Select * from dbo.New where CategoryID = ?";
        return execute(sql, new NewMapper(), categoryID);
    }

    @Override
    public List<New> findTop(int top, String orderby, String ordertype) {
        String sql = "Select top("+top+") * from dbo.New order by " + orderby + " " + ordertype + " ";
        return execute(sql, new NewMapper());
    }

    @Override
    public int getTotalItem() {
        String sqlcount = "Select count(*) from dbo.New";
        return countItem(sqlcount);
    }

    @Override
    public New findByID(Long id) {
        String sql = "Select * from dbo.New where ID = ?";
        List<New> news = execute(sql, new NewMapper(), id);
        return news.isEmpty() ? null : news.get(0);
    }

    @Override
    public Long add(New newNew) {
        String sql = "Insert into dbo.New values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return insert(sql,newNew.getName(),newNew.getTitle(),newNew.getDescription(),newNew.getImage(),
                newNew.getCategoryID(),newNew.getNewDetail(),newNew.getCreatedDate(),newNew.getCreatedBy(),
                newNew.getModifiedDate(),newNew.getModifiedBy(),newNew.getMetaKeyword(),newNew.getMetaDescription(),
                newNew.getViews(),newNew.getTag(),newNew.isStatus());
    }

    @Override
    public Boolean update(New news) {
        String sql = new StringBuilder().append("Update New set Name = ? ,").append("Title = ? ,")
                .append("Description = ? ,").append("Image = ? ,").append("CategoryID = ? ,").append("NewDetail = ? ,")
                .append("ModifiedDate = ? ,").append("ModifiedBy = ? ,").append("MetaKeyword = ? ,")
                .append("MetaDescription = ? ,").append("Tag = ? ,").append("Status = ? ").append("Where ID = ?").toString();
        return update(sql, news.getName(),news.getTitle(),news.getDescription(),news.getImage(),news.getCategoryID(),
                news.getNewDetail(),news.getModifiedDate(),news.getModifiedBy(),news.getMetaKeyword(),news.getMetaDescription(),
                news.getTag(),news.isStatus(),news.getID());
    }

    @Override
    public Boolean delete(Long id) {
        String sql = "Delete from New where ID = ?";
        return update(sql,id);
    }
}
