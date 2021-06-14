package by.itstep.phonebook.controller;

import by.itstep.phonebook.entity.Contact;

import java.util.Set;

public interface ContactController {

    void createContact(Contact contact);
    void deleteContact(Contact contact);
    void findContact(String phone);
    Set<Contact> findByName (String lastName);
}
