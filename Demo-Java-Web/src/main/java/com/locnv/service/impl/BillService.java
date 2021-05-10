package com.locnv.service.impl;

import com.locnv.Model.Bill;
import com.locnv.dao.IBillDAO;
import com.locnv.service.IBillService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class BillService implements IBillService {
    @Inject
    private IBillDAO billDAO;
    @Override
    public Bill add(Bill bill) {
        return billDAO.add(bill);
    }

    @Override
    public Bill findByID(Long id) {
        return billDAO.findByID(id);
    }

    @Override
    public Boolean deleteByID(Long id) {
        return billDAO.deleteByID(id);
    }

    @Override
    public List<Bill> getListBillByStatus(Boolean status) {
        return billDAO.getListBillByStatus(status);
    }

    @Override
    public Boolean updateBill(Long id, String username, Timestamp time) {
        return billDAO.updateBill(id,username,time);
    }

}
