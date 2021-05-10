package com.locnv.Map;

import com.locnv.Model.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements Mapper<Contact> {
    @Override
    public Contact mapRowtoObj(ResultSet rs) {
        try{
            Contact contact = new Contact();
            contact.setID(rs.getLong("ID"));
            contact.setContent(rs.getString("Content"));
            contact.setFacebook(rs.getString("Facebook"));
            contact.setYoutube(rs.getString("Youtube"));
            contact.setGmail(rs.getString("Gmail"));
            contact.setStatus(rs.getBoolean("Status"));
            return contact;
        }catch (SQLException e){
            return null;
        }
    }
}
