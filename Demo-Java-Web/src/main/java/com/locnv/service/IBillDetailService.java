package com.locnv.service;

import com.locnv.Model.BillDetail;

import java.util.List;

public interface IBillDetailService {
    List<BillDetail> findByBillID(Long billID);
    BillDetail findByID(Long billDetailID);
    BillDetail add(BillDetail billDetail);
    Boolean deleteByID(Long id);
}
