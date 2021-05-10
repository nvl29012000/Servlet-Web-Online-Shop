package com.locnv.dao.impl;

import com.locnv.Map.ContactMapper;
import com.locnv.Model.Contact;
import com.locnv.dao.IContactDAO;

import java.util.List;

public class ContactDAO extends CommonDAO<Contact> implements IContactDAO {

    @Override
    public Contact findContact() {
        String sql = "select * from dbo.Contact";
        List<Contact> contacts = execute(sql, new ContactMapper());
        return contacts.isEmpty() ? null : contacts.get(0);
    }

    @Override
    public Contact findByID(Long id) {
        String sql = "Select * from dbo.Contact where ID = ?";
        List<Contact> contacts = execute(sql , new ContactMapper(),id);
        return contacts.isEmpty() ? null : contacts.get(0);
    }

    @Override
    public Boolean update(Contact contact) {
        String sql = new StringBuilder("Update dbo.Contact ").append(" set Content = ? ,").append(" Facebook = ? ,")
                .append(" Youtube = ? ,").append(" Gmail = ? ,").append(" Status = ? ").append(" where ID = ?").toString();
        return update(sql, contact.getContent(),contact.getFacebook(),contact.getYoutube(),contact.getGmail(), contact.isStatus(),contact.getID());
    }
}
