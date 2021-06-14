package by.itstep.phonebook;

import by.itstep.phonebook.controller.ContactController;
import by.itstep.phonebook.controller.impl.ContactControllerImpl;
import by.itstep.phonebook.entity.Address;
import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.entity.Group;

import java.util.HashSet;
import java.util.Set;

public class Run {

    public static void main(String[] args) {
        Set<String> phones = new HashSet<String>();
        phones.add("phone1");
        phones.add("phone2");
        Address address = new Address();
        Set<Group> groups = new HashSet<>();
        ContactController controller = new ContactControllerImpl();
        Contact contact = new Contact("firstName", "LastName",
                phones, address, groups);
        controller.createContact(contact);
    }
}
