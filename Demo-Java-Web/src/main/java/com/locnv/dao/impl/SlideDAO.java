package com.locnv.dao.impl;

import com.locnv.Map.SlideMapper;
import com.locnv.Model.Slide;
import com.locnv.dao.ISlideDAO;

import java.util.List;

public class SlideDAO extends CommonDAO<Slide> implements ISlideDAO {
    @Override
    public List<Slide> findAll() {
        String sql = "Select * from dbo.Slide order by DisplayOrder";
        return execute(sql, new SlideMapper());
    }
}
