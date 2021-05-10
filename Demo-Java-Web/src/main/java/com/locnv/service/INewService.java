package com.locnv.service;

import com.locnv.Model.New;

import java.util.List;

public interface INewService {
    List<New> findAll();
    List<New> findRange(New news);
    List<New> fingByCategoryID(Long categoryID);
    List<New> findTop(int top, String orderby, String ordertype);
    int getTotalItem();
    New findByID(Long id);
    New add(New newNew);
    Boolean update(New news);
    Boolean delete(Long id);
}
