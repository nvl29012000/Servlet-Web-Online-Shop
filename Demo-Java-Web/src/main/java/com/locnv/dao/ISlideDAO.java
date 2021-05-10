package com.locnv.dao;

import com.locnv.Model.Slide;

import java.util.List;

public interface ISlideDAO extends IGenericDAO<Slide> {
    List<Slide> findAll();
}
