package com.locnv.Map;

import com.locnv.Model.New;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMapper implements Mapper<New>{
    @Override
    public New mapRowtoObj(ResultSet rs) {
        try{
            New news = new New();
            news.setID(rs.getLong("ID"));
            news.setName(rs.getString("Name"));
            news.setTitle(rs.getString("Title"));
            news.setDescription(rs.getString("Description"));
            news.setImage(rs.getString("Image"));
            news.setCategoryID(rs.getLong("CategoryID"));
            news.setNewDetail(rs.getString("NewDetail"));
            news.setMetaKeyword(rs.getString("MetaKeyword"));
            news.setMetaDescription(rs.getString("MetaDescription"));
            news.setViews(rs.getLong("Views"));
            news.setTag(rs.getString("Tag"));
            news.setCreatedDate(rs.getTimestamp("CreatedDate"));
            news.setCreatedBy(rs.getString("CreatedBy"));
            news.setModifiedDate(rs.getTimestamp("ModifiedDate"));
            news.setModifiedBy(rs.getString("ModifiedBy"));
            news.setStatus(rs.getBoolean("Status"));
            return news;
        }catch (SQLException e){
            return null;
        }
    }
}
