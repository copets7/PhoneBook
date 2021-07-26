package by.itstep.phonebook.dao;

import by.itstep.phonebook.entity.Contact;

import java.util.List;

public interface ContactDAO {

    Contact save(Contact contact);

    List<Contact> findAll();
}
