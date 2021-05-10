package com.locnv.dao;

import com.locnv.Model.BillDetail;

import java.util.List;

public interface IBillDetailDAO extends IGenericDAO<BillDetail>{
    List<BillDetail> findByBillID(Long billID);
    BillDetail add(BillDetail billDetail);
    BillDetail findByID(Long billDetailID);
    Boolean deleteByID(Long id);
}
