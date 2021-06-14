package by.itstep.phonebook.parser.csv;

import by.itstep.phonebook.entity.Contact;

import java.util.Set;

import static by.itstep.phonebook.parser.csv.ParserProperties.SEPARATOR;

public class ContactParser {

    public static String parseContact(Contact contact) {
        StringBuilder contactLine = new StringBuilder();
        contactLine.append(SEPARATOR);
        contactLine.append(contact.getFirsName());
        contactLine.append(SEPARATOR);
        contactLine.append(contact.getLastName());
        contactLine.append(SEPARATOR);
        contactLine.append(parsePhones(contact.getPhones()));
        contactLine.append(SEPARATOR);
        contactLine.append(contact.getAddresse().getId());
        return contactLine.toString();
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
