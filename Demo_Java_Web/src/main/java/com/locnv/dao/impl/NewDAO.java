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
    public int getTotalItem() {
        String sqlcount = "Select count(*) from dbo.New";
        return countItem(sqlcount);
    }
}
