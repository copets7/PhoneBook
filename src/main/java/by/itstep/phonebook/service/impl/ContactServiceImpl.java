package by.itstep.phonebook.service.impl;

import by.itstep.phonebook.dao.ContactDAO;
import by.itstep.phonebook.dao.DaoFactory;
import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.service.ContactService;

public class ContactServiceImpl implements ContactService {

    private ContactDAO contactDAO;

    public ContactServiceImpl() {
        this.contactDAO = DaoFactory.getInstance().getContactDAO();
    }

    @Override
    public void createContact(Contact contact) {
        if (validateContact(contact)) {
            contactDAO.createContact(contact);
        }
    }

    // TODO throw Exception
    private boolean validateContact(Contact contact) {
        return true;
    }
}
