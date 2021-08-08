package by.itstep.phonebook.service;

import by.itstep.phonebook.entity.Contact;

import java.util.List;

public interface ContactService {

    void createContact(Contact contact) throws ServiceException;

    List<Contact> getAll();
}
