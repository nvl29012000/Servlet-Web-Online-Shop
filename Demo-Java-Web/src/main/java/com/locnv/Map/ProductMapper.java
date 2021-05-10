package com.locnv.Map;

import com.locnv.Model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements Mapper<Product>{
    @Override
    public Product mapRowtoObj(ResultSet rs) {
        try{
            Product product = new Product();
            product.setID(rs.getLong("ID"));
            product.setName(rs.getString("Name"));
            product.setProductCode(rs.getString("ProductCode"));
            product.setTitle(rs.getString("Title"));
            product.setDescription(rs.getString("Description"));
            product.setImage(rs.getString("Image"));
            product.setPrice(rs.getBigDecimal("Price"));
            product.setSalePrice(rs.getBigDecimal("SalePrice"));
            product.setQuantity(rs.getInt("Quantity"));
            product.setCategoryID(rs.getLong("CategoryID"));
            product.setProductDetail(rs.getString("ProductDetail"));
            product.setSaleDate(rs.getTimestamp("SaleDate"));
            product.setCreatedDate(rs.getTimestamp("CreatedDate"));
            product.setCreatedBy(rs.getString("CreatedBy"));
            product.setModifiedDate(rs.getTimestamp("ModifiedDate"));
            product.setModifiedBy(rs.getString("ModifiedBy"));
            product.setStatus(rs.getBoolean("Status"));
            return product;
        }catch (SQLException ex){
            return null;
        }
    }
}
