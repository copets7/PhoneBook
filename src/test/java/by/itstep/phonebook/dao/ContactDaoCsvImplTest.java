package by.itstep.phonebook.dao;

import by.itstep.phonebook.conection.ConnectionCsvImpl;
import by.itstep.phonebook.dao.impl.ContactDaoCsvImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactDaoCsvImplTest {

    @InjectMocks
    private ContactDaoCsvImpl contactDAO;

    @Mock
    private ConnectionCsvImpl connection;

    @Before
    public void setUp(){
        when(ConnectionCsvImpl.getInstance()).thenReturn(connection);
    }

    @Test
    public void createContactTest_Success() {
        
    }
}
