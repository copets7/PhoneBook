package by.itstep.phonebook.connecton;

import by.itstep.phonebook.Properties;
import by.itstep.phonebook.conection.Connection;
import org.junit.Test;

import java.io.File;

public class ConnectionTest {

    private static final Connection connection = Connection.getInstance();
    public static final String TEST_ROOT;
    public static final String CONTACT_HAS_GROUP_PATH;
    public static final String CONTACT_PATH;

    static {
        StringBuilder path = new StringBuilder(Properties.ROOT_DIR);
        path.delete(path.length() - 2, path.length());
        path.append("src");
        path.append(File.separator);
        path.append("test");
        path.append(File.separator);
        path.append("resources");
        TEST_ROOT = path.toString();
        CONTACT_HAS_GROUP_PATH = TEST_ROOT + File.separator + "contact_has_group.csv";
        CONTACT_PATH = TEST_ROOT + File.separator + "contacts.csv";
    }

    @Test
    public void getIdTest(){
        Integer id = connection.getId(CONTACT_HAS_GROUP_PATH);
        Integer contactId = connection.getId(CONTACT_PATH);
        System.out.println(id);
        System.out.println(contactId);
    }
}
