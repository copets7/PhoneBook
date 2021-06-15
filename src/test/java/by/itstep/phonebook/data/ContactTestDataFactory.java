package by.itstep.phonebook.data;

import by.itstep.phonebook.entity.Address;
import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.entity.Group;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ContactTestDataFactory {


    public static Contact createContact(String lastName,
                                        String phone) {
        return createContact(lastName, phone, null, null);
    }

    public static Contact createContact(String lastName,
                                        String phone,
                                        Address address,
                                        Set<Group> groups) {
        return new Contact("testFirstName", lastName,
                new HashSet<>(Collections.singletonList(phone)),
                address, groups);
    }
}
