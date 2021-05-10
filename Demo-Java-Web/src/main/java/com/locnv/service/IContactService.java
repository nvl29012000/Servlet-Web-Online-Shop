package com.locnv.service;

import com.locnv.Model.Contact;

public interface IContactService {
    Contact findContact();
    Contact findByID(Long id);
    Boolean update(Contact contact);
}
