package com.locnv.Map;

import com.locnv.Model.BillDetail;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillDetailMapper implements Mapper<BillDetail>{
    @Override
    public BillDetail mapRowtoObj(ResultSet rs) {
        try{
            BillDetail billDetail = new BillDetail();
            billDetail.setID(rs.getLong("ID"));
            billDetail.setProductID(rs.getLong("ProductID"));
            billDetail.setBillID(rs.getLong("BillID"));
            billDetail.setQuantity(rs.getInt("Quantity"));
            billDetail.setPrice(rs.getBigDecimal("Price"));
            return  billDetail;
        }catch (SQLException e){
            return null;
        }
    }
}
