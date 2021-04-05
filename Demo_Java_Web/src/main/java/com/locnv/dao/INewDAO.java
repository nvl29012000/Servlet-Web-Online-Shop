package com.locnv.dao;

import com.locnv.Model.New;

import java.util.List;

public interface INewDAO extends IGenericDAO<New> {
    List<New> findAll();
    List<New> findRange(int page, int items);
    int getTotalItem();
}
