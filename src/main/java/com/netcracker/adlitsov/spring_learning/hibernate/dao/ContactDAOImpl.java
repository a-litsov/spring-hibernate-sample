package com.netcracker.adlitsov.spring_learning.hibernate.dao;

import com.netcracker.adlitsov.spring_learning.hibernate.model.Contact;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("contactDAO")
public class ContactDAOImpl extends AbstractDAO implements ContactDAO {
    public void saveContact(Contact contact) {
        persist(contact);
    }

    public List<Contact> findAllContacts() {
        Criteria criteria = getSession().createCriteria(Contact.class);
        return (List<Contact>)criteria.list();
    }

    public Contact findContactById(int id) {
        Criteria criteria = getSession().createCriteria(Contact.class);
        criteria.add(Restrictions.eq("id", id));
        return (Contact)criteria.uniqueResult();
    }

    public void deleteContactById(int id) {
        Query query = getSession().createQuery("delete from Contact where id=:id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
}
