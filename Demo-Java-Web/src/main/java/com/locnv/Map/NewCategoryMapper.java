package com.locnv.Map;

import com.locnv.Model.NewCategory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewCategoryMapper implements Mapper<NewCategory> {
    @Override
    public NewCategory mapRowtoObj(ResultSet rs) {
        try{
            NewCategory newcate = new NewCategory();
            newcate.setID(rs.getLong("ID"));
            newcate.setName(rs.getString("Name"));
            newcate.setTitle(rs.getString("Title"));
            newcate.setParentID(rs.getLong("ParentID"));
            newcate.setDisplayOrder(rs.getInt("DisplayOrder"));
            newcate.setSeoTitle(rs.getString("SeoTitle"));
            newcate.setMetaKeyword(rs.getString("MetaKeyword"));
            newcate.setMetaDescription(rs.getString("MetaDescription"));
            newcate.setShowOnHome(rs.getBoolean("ShowOnHome"));
            newcate.setStatus(rs.getBoolean("Status"));
            newcate.setCreatedDate(rs.getTimestamp("CreatedDate"));
            newcate.setCreatedBy(rs.getString("CreatedBy"));
            newcate.setModifiedDate(rs.getTimestamp("ModifiedDate"));
            newcate.setModifiedBy(rs.getString("ModifiedBy"));
            return newcate;
        }catch (SQLException ex){
            return null;
        }
    }
}
