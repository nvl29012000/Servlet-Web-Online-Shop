package com.locnv.dao;

import com.locnv.Model.New;

import java.util.List;

public interface INewDAO extends IGenericDAO<New> {
    List<New> findAll();
    List<New> findRange(int page, int items);
    List<New> findByCategoryID(Long categoryID);
    List<New> findTop(int top, String orderby, String ordertype);
    int getTotalItem();
    New findByID(Long id);
    Long add(New newNew);
    Boolean update(New news);
    Boolean delete(Long id);
}
