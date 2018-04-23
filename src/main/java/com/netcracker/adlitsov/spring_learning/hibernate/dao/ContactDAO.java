package com.netcracker.adlitsov.spring_learning.hibernate.dao;

import com.netcracker.adlitsov.spring_learning.hibernate.model.Contact;

import java.util.List;

public interface ContactDAO {
    void saveContact(Contact contact);

    List<Contact> findAllContacts();

    Contact findContactById(int id);

    void deleteContactById(int id);
}
