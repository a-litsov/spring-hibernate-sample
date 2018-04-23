package com.netcracker.adlitsov.spring_learning.hibernate.service;

import com.netcracker.adlitsov.spring_learning.hibernate.dao.ContactDAO;
import com.netcracker.adlitsov.spring_learning.hibernate.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactDAO contactDAO;

    public void saveContact(Contact contact) {
        contactDAO.saveContact(contact);
    }

    public List<Contact> findAllContacts() {
        return contactDAO.findAllContacts();
    }

    public Contact findContactById(int id) {
        return contactDAO.findContactById(id);
    }

    public void deleteContactById(int id) {
        contactDAO.deleteContactById(id);
    }
}
