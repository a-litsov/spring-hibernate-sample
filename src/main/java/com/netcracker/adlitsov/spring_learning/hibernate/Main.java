package com.netcracker.adlitsov.spring_learning.hibernate;

import com.netcracker.adlitsov.spring_learning.hibernate.config.SpringConfiguration;
import com.netcracker.adlitsov.spring_learning.hibernate.model.Contact;
import com.netcracker.adlitsov.spring_learning.hibernate.service.ContactService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ContactService contactService = context.getBean("contactService", ContactService.class);

        System.out.println("Before: " + contactService.findAllContacts());
        contactService.saveContact(new Contact("Mikhail", "Abramov", new Date()));
        System.out.println("After: " + contactService.findAllContacts());
    }
}
