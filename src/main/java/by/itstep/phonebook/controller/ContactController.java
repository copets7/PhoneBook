package by.itstep.phonebook.controller;

import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.service.ServiceException;

import java.util.List;
import java.util.Set;

public interface ContactController {

    void createContact(Contact contact) throws ServiceException;

    List<Contact> getAll();

    void deleteContact(Contact contact);
    void findContact(String phone);
    Set<Contact> findByName (String lastName);
}
