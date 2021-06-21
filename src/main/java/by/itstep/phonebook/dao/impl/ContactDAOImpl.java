package by.itstep.phonebook.dao.impl;

import by.itstep.phonebook.dao.ContactDAO;
import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.entity.Group;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static by.itstep.phonebook.Properties.CONTACT_FILE_PATH;
import static by.itstep.phonebook.conection.Connection.getId;
import static by.itstep.phonebook.conection.Connection.writeToFileOneLine;
import static by.itstep.phonebook.parser.csv.ContactParser.parseContact;
import static by.itstep.phonebook.parser.csv.ContactParser.parseContactHasGroup;

public class ContactDAOImpl implements ContactDAO {

    @Override
    public void insertContact(Contact contact) {
        String contactLine = parseContact(contact);
        Long id = getId(CONTACT_FILE_PATH);
        contactLine = id + contactLine;
        writeToFileOneLine(CONTACT_FILE_PATH, contactLine);

        Set<Group> groups = contact.getGroups();
        if (groups != null && !groups.isEmpty()) {
            Map<Long, Long> idMap = getIdMap(Contact contact);
            Set<String> contactHasGroup = parseContactHasGroup(contact)



            contactLine = String.valueOf(id) + contactLine;
            writeToFileOneLine(CONTACT_FILE_PATH, contactLine);
        } else {
            // inser group has contacrt
        }
    }

    private Map<Integer, Integer> getIdMap(Contact contact) {
        Map<Integer, Integer> idMap = new HashMap<>();
        for (Group group : contact.getGroups()) {
            idMap.put(contact.getId(), group.getId());
        }
        return idMap;
    }


}
