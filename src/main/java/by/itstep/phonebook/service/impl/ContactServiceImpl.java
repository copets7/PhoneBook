package by.itstep.phonebook.service.impl;

import by.itstep.phonebook.dao.ContactDAO;
import by.itstep.phonebook.dao.DaoFactory;
import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.entity.Group;
import by.itstep.phonebook.service.ContactService;
import by.itstep.phonebook.service.ServiceException;

import java.util.Set;
import java.util.stream.Collectors;

import static by.itstep.phonebook.Utils.*;

public class ContactServiceImpl implements ContactService {

    private ContactDAO contactDAO;

    public ContactServiceImpl() {
        this.contactDAO = DaoFactory.getInstance().getContactDAO();
    }

    @Override
    public void createContact(Contact contact) throws ServiceException {
        if (validateNewContact(contact)) {
            Set<Group> groups = contact.getGroups();
            if (groups != null && !groups.isEmpty()) {
                groups = groups.stream().filter(group ->
                                group.getId() == null).collect(Collectors.toSet());
                if (groups.isEmpty()) {
                    contact.setGroups(null);
                } else {
                    contact.setGroups(groups);
                }
            }
            contactDAO.save(contact);
        }
    }

    private boolean validateNewContact(Contact contact) throws ServiceException {
        if (contact == null) throw new ServiceException("Contact is null");
        if (!isText(contact.getFirsName()))
            throw new ServiceException("Contact firstName must contain only letters");
        if (!isText(contact.getLastName()))
            throw new ServiceException("Contact lastName must contain only letters");
        if (!isEmail(contact.getEmail())) {
            throw new ServiceException("Contact email is not valid");
        }
        if (contact.getPhones().isEmpty()) {
            throw new ServiceException("Contact must contain at least one phone");
        } else {
            if (!isPhones(contact.getPhones()))
                throw new ServiceException("Contact phone format is illegal. Try +###-##-#######");
        }
        return true;
    }
}
