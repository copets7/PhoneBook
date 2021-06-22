package by.itstep.phonebook.dao.impl;

import by.itstep.phonebook.conection.Connection;
import by.itstep.phonebook.dao.ContactDAO;
import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.entity.Group;
import by.itstep.phonebook.entity.pojo.ContactHasGroup;

import java.util.*;

import static by.itstep.phonebook.Properties.CONTACT_FILE_PATH;
import static by.itstep.phonebook.Properties.CONTACT_HAS_GROUP_FILE_PATH;

public class ContactDAOImpl implements ContactDAO {

    private Connection connection = Connection.getInstance();

    @Override
    public Contact insertContact(Contact contact) {
        Integer id = connection.getId(CONTACT_FILE_PATH);
        contact.setId(id);
        connection.writeCsvFromBean(CONTACT_FILE_PATH, Collections.singletonList(contact));
        Set<Group> groups = contact.getGroups();
        if (groups != null && !groups.isEmpty()) {
            Integer contactHasGroupId = connection.getId(CONTACT_HAS_GROUP_FILE_PATH);
            List<ContactHasGroup> chgRecords =
                    ContactHasGroup.parse(contact, contactHasGroupId);
            connection.writeCsvFromBean(CONTACT_HAS_GROUP_FILE_PATH, chgRecords);
        }
        return contact;
    }

    private Map<Integer, Integer> getIdMap(Contact contact) {
        Map<Integer, Integer> idMap = new HashMap<>();
        for (Group group : contact.getGroups()) {
            idMap.put(contact.getId(), group.getId());
        }
        return idMap;
    }


}
