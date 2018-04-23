package com.netcracker.adlitsov.spring_learning.hibernate.service;

import com.netcracker.adlitsov.spring_learning.hibernate.model.Contact;

import java.util.List;

public interface ContactService {
    void saveContact(Contact contact);

    List<Contact> findAllContacts();

    Contact findContactById(int id);

    void deleteContactById(int id);
}
