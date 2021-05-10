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
    public List<New> fingByCategoryID(Long categoryID) {
        return newDAO.findByCategoryID(categoryID);
    }

    @Override
    public List<New> findTop(int top, String orderby, String ordertype) {
        return newDAO.findTop(top, orderby, ordertype);
    }

    @Override
    public int getTotalItem() {
        return newDAO.getTotalItem();
    }

    @Override
    public New findByID(Long id) {
        return newDAO.findByID(id);
    }

    @Override
    public New add(New newNew) {
        Long id = newDAO.add(newNew);
        return newDAO.findByID(id);
    }

    @Override
    public Boolean update(New news) {
        return newDAO.update(news);
    }

    @Override
    public Boolean delete(Long id) {
        return newDAO.delete(id);
    }
}
