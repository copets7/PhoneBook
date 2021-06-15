package by.itstep.phonebook.sevice;

import by.itstep.phonebook.dao.ContactDAO;
import by.itstep.phonebook.dao.DaoFactory;
import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.service.ServiceException;
import by.itstep.phonebook.service.impl.ContactServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static by.itstep.phonebook.data.ContactTestDataFactory.createContact;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceImplTest {

    private final String PHONE_ERROR = "Contact phone format is illegal. Try +###-##-#######";
    @InjectMocks
    private ContactServiceImpl contactService;
    @Mock
    private DaoFactory daoFactory;
    @Mock
    private ContactDAO contactDAO;

    private Contact validContact = createContact("TestLastName",
            "+375-29-1234567");
    private Contact invalidContact = createContact("TestLastName",
            "+375-29-12347");

    @Before
    public void setUp() {
        when(daoFactory.getContactDAO()).thenReturn(contactDAO);
    }

    @Test
    public void createContactTest_Success() {
        try {
            contactService.createContact(validContact);
        } catch (ServiceException e) {
            assertNull(e);
        }
    }

    @Test()
    public void createContactTest_Exception() {
        try {
            contactService.createContact(validContact);
        } catch (ServiceException e) {
            assertEquals(e.getClass(), ServiceException.class);
            assertEquals(e.getMessage(), PHONE_ERROR);
        }
    }
}
