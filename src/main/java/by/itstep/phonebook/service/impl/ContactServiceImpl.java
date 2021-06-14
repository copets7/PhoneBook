package by.itstep.phonebook.service.impl;

import by.itstep.phonebook.dao.ContactDAO;
import by.itstep.phonebook.dao.DaoFactory;
import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.service.ContactService;
import by.itstep.phonebook.service.ServiceException;

import static by.itstep.phonebook.Utils.isPhones;
import static by.itstep.phonebook.Utils.isText;

public class ContactServiceImpl implements ContactService {

    private ContactDAO contactDAO;

    public ContactServiceImpl() {
        this.contactDAO = DaoFactory.getInstance().getContactDAO();
    }

    @Override
    public void createContact(Contact contact) throws ServiceException {
        if (validateNewContact(contact)) {
            contactDAO.createContact(contact);
        }
    }

    private boolean validateNewContact(Contact contact) throws ServiceException {
        if (contact == null) throw new ServiceException("Contact is null");
        if (!isText(contact.getFirsName()))
            throw new ServiceException("Contact firstName must contain only letters");
        if (!isText(contact.getLastName()))
            throw new ServiceException("Contact lastName must contain only letters");
        if (contact.getPhones().isEmpty()){
            throw new ServiceException("Contact must contain at least one phone");
        } else {
            if (!isPhones(contact.getPhones()))
                throw new ServiceException("Contact phone format is illegal. Try +###-##-#######");
        }
        return true;
    }
}
