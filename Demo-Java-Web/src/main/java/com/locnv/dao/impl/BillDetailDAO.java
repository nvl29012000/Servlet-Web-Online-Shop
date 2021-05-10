package com.locnv.dao.impl;

import com.locnv.Map.BillDetailMapper;
import com.locnv.Model.BillDetail;
import com.locnv.dao.IBillDetailDAO;

import java.util.List;

public class BillDetailDAO extends CommonDAO<BillDetail> implements IBillDetailDAO {
    @Override
    public List<BillDetail> findByBillID(Long billID) {
        String sql = "Select * from dbo.BillDetail where BillID = ?";
        return execute(sql,new BillDetailMapper(),billID);
    }

    @Override
    public BillDetail add(BillDetail billDetail) {
        String sql = "Insert into dbo.BillDetail values(?,?,?,?)";
        Long id = insert(sql,billDetail.getProductID(),billDetail.getBillID(),billDetail.getQuantity(),billDetail.getPrice());
        return findByID(id);
    }

    @Override
    public BillDetail findByID(Long billDetailID) {
        String sql = "Select * from dbo.BillDetail where ID = ?";
        List<BillDetail> list = execute(sql,new BillDetailMapper(),billDetailID);
        return list.isEmpty()? null : list.get(0);
    }

    @Override
    public Boolean deleteByID(Long id) {
        String sql = "Delete from dbo.BillDetail where ID = ?";
        return update(sql, id);
    }
}
