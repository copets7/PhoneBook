package by.itstep.phonebook.dao;

import by.itstep.phonebook.conection.Connection;
import by.itstep.phonebook.dao.impl.ContactDAOImpl;
import by.itstep.phonebook.service.ServiceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactDAOImplTest {

    @InjectMocks
    private ContactDAOImpl contactDAO;

    @Mock
    private Connection connection;

    @Before
    public void setUp(){
        when(Connection.getInstance()).thenReturn(connection);
    }

    @Test
    public void createContactTest_Success() {
        
    }
}
