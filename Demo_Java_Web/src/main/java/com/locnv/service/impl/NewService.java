package com.locnv.service.impl;

import com.locnv.Model.New;
import com.locnv.dao.INewDAO;
import com.locnv.service.INewService;

import javax.inject.Inject;
import java.util.List;

public class NewService implements INewService {
    @Inject
    private INewDAO newDAO;
    @Override
    public List<New> findAll() {
        return newDAO.findAll();
    }

    @Override
    public List<New> findRange(New news) {
        return newDAO.findRange(news.getPage(), news.getItems());
    }

    @Override
    public int getTotalItem() {
        return newDAO.getTotalItem();
    }
}
