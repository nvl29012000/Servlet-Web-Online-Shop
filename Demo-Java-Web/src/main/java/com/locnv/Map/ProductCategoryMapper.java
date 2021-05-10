package com.locnv.Map;

import com.locnv.Model.ProductCategory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCategoryMapper implements Mapper<ProductCategory> {
    @Override
    public ProductCategory mapRowtoObj(ResultSet rs) {
        try{
            ProductCategory productCategory = new ProductCategory();
            productCategory.setID(rs.getLong("ID"));
            productCategory.setName(rs.getString("Name"));
            productCategory.setTitle(rs.getString("Title"));
            productCategory.setDisplayOrder(rs.getInt("DisplayOrder"));
            productCategory.setParentID(rs.getLong("ParentID"));
            productCategory.setSeoTitle(rs.getString("SeoTitle"));
            productCategory.setMetaKeyword(rs.getString("MetaKeyword"));
            productCategory.setMetaDescription(rs.getString("MetaDescription"));
            productCategory.setCreatedDate(rs.getTimestamp("CreatedDate"));
            productCategory.setCreatedBy(rs.getString("CreatedBy"));
            productCategory.setModifiedDate(rs.getTimestamp("ModifiedDate"));
            productCategory.setModifiedBy(rs.getString("ModifiedBy"));
            productCategory.setShowOnHome(rs.getBoolean("ShowOnHome"));
            productCategory.setStatus(rs.getBoolean("Status"));
            productCategory.setImage(rs.getString("Image"));
            return productCategory;
        }catch (SQLException e){
            return null;
        }
    }
}
