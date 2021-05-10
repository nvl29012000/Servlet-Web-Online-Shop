package com.locnv.service.impl;

import com.locnv.Model.Contact;
import com.locnv.dao.IContactDAO;
import com.locnv.service.IContactService;

import javax.inject.Inject;

public class ContactService implements IContactService {
    @Inject
    private IContactDAO contactDAO;
    @Override
    public Contact findContact() {
        return contactDAO.findContact();
    }

    @Override
    public Contact findByID(Long id) {
        return contactDAO.findByID(id);
    }

    @Override
    public Boolean update(Contact contact) {
        return contactDAO.update(contact);
    }
}
