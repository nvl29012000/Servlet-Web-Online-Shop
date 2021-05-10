package com.locnv.dao.impl;

import com.locnv.Map.BillMapper;
import com.locnv.Model.Bill;
import com.locnv.dao.IBillDAO;

import java.sql.Timestamp;
import java.util.List;

public class BillDAO extends CommonDAO<Bill> implements IBillDAO {
    @Override
    public Bill add(Bill bill) {
        String sql = "Insert into dbo.Bill values(?,?,?,?,?,?,?,?,?,?,?,?)";
        Long id = insert(sql,bill.getUserID(),bill.getName(),bill.getPhone(),bill.getEmail(),bill.getAddress(),
                bill.getCreatedDate(),bill.getConfirmDate(),bill.getConfirmBy(),bill.getDiscount(),bill.getPayment(),bill.getDetail(),bill.isStatus());
        return findByID(id);
    }

    @Override
    public Bill findByID(Long id) {
        String sql = "Select * from dbo.Bill where ID = ?";
        List<Bill> list = execute(sql, new BillMapper(),id);
        return list.isEmpty()? null : list.get(0);
    }

    @Override
    public Boolean deleteByID(Long id) {
        String sql = "Delete from dbo.Bill where ID = ?";
        return update(sql,id);
    }

    @Override
    public List<Bill> getListBillByStatus(Boolean status) {
        String sql = "Select * from dbo.Bill where Status = ?";
        return execute(sql, new BillMapper(),status);
    }

    @Override
    public Boolean updateBill(Long id, String username, Timestamp time) {
        String sql = "Update dbo.Bill set ConfirmDate = ?, ConfirmBy = ?, Status = abs(Status - 1) where ID = ?";
        return update(sql, time, username, id);
    }

}
