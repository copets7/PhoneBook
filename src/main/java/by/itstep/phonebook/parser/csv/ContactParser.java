package by.itstep.phonebook.parser.csv;

import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.entity.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static by.itstep.phonebook.parser.csv.ParserProperties.SEPARATOR;

public class ContactParser {

    public static String parseContact(Contact contact) {
        StringBuilder contactLine = new StringBuilder();
        contactLine.append(contact.getId());
        contactLine.append(SEPARATOR);
        contactLine.append(contact.getFirsName());
        contactLine.append(SEPARATOR);
        contactLine.append(contact.getLastName());
        contactLine.append(SEPARATOR);
        contactLine.append(contact.getEmail());
        contactLine.append(SEPARATOR);
        contactLine.append(parsePhones(contact.getPhones()));
        return contactLine.toString();
    }

    public static List<String> parseContactHasGroup(Contact contact){
        List<String> records = new ArrayList<>();
        for (Group group: contact.getGroups()){
            StringBuilder recordLine = new StringBuilder();
            recordLine.append("null");
            recordLine.append(SEPARATOR);
            recordLine.append(contact.getId());
            recordLine.append(SEPARATOR);
            recordLine.append(group.getId());
            records.add(recordLine.toString());
        }
        return records;
    }

    private static String parsePhones(Set<String> phones){
        StringBuilder phoneLine = new StringBuilder("\"");
        for (String phone: phones){
            phoneLine.append(phone);
            phoneLine.append(SEPARATOR);
        }
        phoneLine.append("\"");
        return phoneLine.toString();
    }
}
