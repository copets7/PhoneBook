package by.itstep.phonebook.dao.impl;

import by.itstep.phonebook.dao.ContactDAO;
import by.itstep.phonebook.entity.Contact;

import java.io.File;

import static by.itstep.phonebook.Properties.CONTACT_FILE_PATH;
import static by.itstep.phonebook.conection.Connection.getNumberOfRecords;
import static by.itstep.phonebook.conection.Connection.writeToFileOneLine;
import static by.itstep.phonebook.parser.csv.ContactParser.parseContact;

public class ContactDAOImpl implements ContactDAO {

    @Override
    public void createContact(Contact contact) {
        String contactLine = parseContact(contact);
        // TODO createAdres and create Group
        if (contact.getGroups().isEmpty()){
            long id = getNumberOfRecords(CONTACT_FILE_PATH) + 1;
            contactLine = String.valueOf(id) + contactLine;
            writeToFileOneLine(CONTACT_FILE_PATH, contactLine);
        } else {
            // inser group has contacrt
        }
    }


}
