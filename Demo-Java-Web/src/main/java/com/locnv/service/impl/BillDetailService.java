package com.locnv.service.impl;

import com.locnv.Model.BillDetail;
import com.locnv.dao.IBillDetailDAO;
import com.locnv.service.IBillDetailService;

import javax.inject.Inject;
import java.util.List;

public class BillDetailService implements IBillDetailService {
    @Inject
    private IBillDetailDAO billDetailDAO;
    @Override
    public List<BillDetail> findByBillID(Long billID) {
        return billDetailDAO.findByBillID(billID);
    }

    @Override
    public BillDetail findByID(Long billDetailID) {
        return billDetailDAO.findByID(billDetailID);
    }

    @Override
    public BillDetail add(BillDetail billDetail) {
        return billDetailDAO.add(billDetail);
    }

    @Override
    public Boolean deleteByID(Long id) {
        return billDetailDAO.deleteByID(id);
    }

}
