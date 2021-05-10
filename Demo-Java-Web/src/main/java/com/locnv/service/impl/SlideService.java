package com.locnv.service.impl;

import com.locnv.Model.Slide;
import com.locnv.dao.ISlideDAO;
import com.locnv.service.ISlideService;

import javax.inject.Inject;
import java.util.List;

public class SlideService implements ISlideService {
    @Inject
    private ISlideDAO slideDAO;
    @Override
    public List<Slide> findAll() {
        return slideDAO.findAll();
    }
}
