package com.locnv.dao;

import com.locnv.Model.Contact;

public interface IContactDAO extends IGenericDAO<Contact> {
    Contact findContact();
    Contact findByID(Long id);
    Boolean update(Contact contact);
}
