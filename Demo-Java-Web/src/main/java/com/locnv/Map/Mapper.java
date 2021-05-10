package com.locnv.Map;

import java.sql.ResultSet;

public interface Mapper<T> {
    T mapRowtoObj(ResultSet rs);
}
