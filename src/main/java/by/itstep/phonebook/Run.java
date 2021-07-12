package by.itstep.phonebook;

import by.itstep.phonebook.dao.ContactDAO;
import by.itstep.phonebook.dao.impl.ContactDaoJdbsImpl;
import by.itstep.phonebook.entity.Contact;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Run {

    public static void main(String[] args) {

        Contact contact = new Contact("Ilia", "Madison",
                new HashSet<>(Collections.singletonList("+375-29-1233")), "mad@fakeemail.com", null);
        ContactDAO contactDAO = new ContactDaoJdbsImpl();
        contactDAO.save(contact);
        System.out.println(contact.getId());
    }
}
