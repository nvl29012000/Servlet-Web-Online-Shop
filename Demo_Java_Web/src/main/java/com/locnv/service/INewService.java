package com.locnv.service;

import com.locnv.Model.New;

import java.util.List;

public interface INewService {
    List<New> findAll();
    List<New> findRange(New news);
    int getTotalItem();
}
