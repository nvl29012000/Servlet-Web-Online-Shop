package com.locnv.dao;

import com.locnv.Map.Mapper;

import java.util.List;

public interface IGenericDAO<T> {
    <T> List<T> execute(String sql, Mapper<T> mapper, Object... parameters);
    int countItem(String sql, Object... parameters);
    Long insert(String sql, Object... parameters);
    Boolean update(String sql, Object... parameters);
}
