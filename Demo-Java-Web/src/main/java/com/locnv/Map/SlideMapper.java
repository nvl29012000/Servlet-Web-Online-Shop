package com.locnv.Map;

import com.locnv.Model.Slide;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SlideMapper implements Mapper<Slide> {
    @Override
    public Slide mapRowtoObj(ResultSet rs) {
        try {
            Slide slide = new Slide();
            slide.setID(rs.getLong("ID"));
            slide.setImage(rs.getString("Image"));
            slide.setDisplayOrder(rs.getInt("DisplayOrder"));
            slide.setLink(rs.getString("Link"));
            slide.setDescription(rs.getString("Description"));
            slide.setCreatedDate(rs.getTimestamp("CreatedDate"));
            slide.setCreatedBy(rs.getString("CreatedBy"));
            slide.setModifiedDate(rs.getTimestamp("ModifiedDate"));
            slide.setModifiedBy(rs.getString("ModifiedBy"));
            slide.setStatus(rs.getBoolean("Status"));
            return slide;
        }catch (SQLException e){
            return null;
        }
    }
}
