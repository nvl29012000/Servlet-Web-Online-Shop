package com.locnv.Map;

import com.locnv.Model.Bill;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillMapper implements Mapper<Bill> {
    @Override
    public Bill mapRowtoObj(ResultSet rs) {
        try{
            Bill bill = new Bill();
            bill.setID(rs.getLong("ID"));
            bill.setUserID(rs.getLong("UserID"));
            bill.setName(rs.getString("Name"));
            bill.setPhone(rs.getString("Phone"));
            bill.setEmail(rs.getString("Email"));
            bill.setAddress(rs.getString("Address"));
            bill.setCreatedDate(rs.getTimestamp("CreatedDate"));
            bill.setConfirmDate(rs.getTimestamp("ConfirmDate"));
            bill.setConfirmBy(rs.getString("ConfirmBy"));
            bill.setDiscount(rs.getFloat("Discount"));
            bill.setPayment(rs.getString("Payment"));
            bill.setDetail(rs.getString("Detail"));
            bill.setStatus(rs.getBoolean("Status"));
            return bill;
        }catch (SQLException e){
            return null;
        }
    }
}
