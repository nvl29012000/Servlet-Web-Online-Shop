package com.locnv.service;

import com.locnv.Model.Bill;

import java.sql.Timestamp;
import java.util.List;

public interface IBillService {
    Bill add(Bill bill);
    Bill findByID(Long id);
    Boolean deleteByID(Long id);
    List<Bill> getListBillByStatus(Boolean status);
    Boolean updateBill(Long id, String username, Timestamp time);
}
