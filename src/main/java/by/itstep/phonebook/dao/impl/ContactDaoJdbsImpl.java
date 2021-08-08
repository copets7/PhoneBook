package by.itstep.phonebook.dao.impl;

import by.itstep.phonebook.dao.ContactDAO;
import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.entity.Group;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactDaoJdbsImpl implements ContactDAO {

    private static final String queryGetAll = "SELECT contact.id,\n" +
            "       contact.first_name,\n" +
            "       contact.last_name,\n" +
            "       contact.email,\n" +
            "       contact.phones,\n" +
            "       `group`.name\n" +
            "FROM contact\n" +
            "         LEFT JOIN contact_has_role ON contact.id = contact_has_role.contact_id\n" +
            "         LEFT JOIN `group` ON contact_has_role.group_id = `group`.id;";

    Connection connection;

    public ContactDaoJdbsImpl() {
        getConnection("database");
    }

    @Override
    public Contact save(Contact contact) {
        if (connection != null) {
            Savepoint savepoint = null;
            List<String> values = Stream.of(contact.getFirsName(), contact.getLastName(), contact.getEmail(), contact.getPhones()).
                    map(String::valueOf).collect(Collectors.toList());
            String query = "INSERT INTO contact (first_name, last_name, email, phones) VALUES ('" + String.join("', '", values) + "')";
            try {
                savepoint = connection.setSavepoint();
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                statement.executeUpdate();
                connection.commit();
                ResultSet res = statement.getGeneratedKeys();
                res.next();
                contact.setId(res.getInt(1));
                return contact;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    connection.rollback(savepoint);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } finally {
                closeConnection();
            }
        }
        return null;
    }

    @Override
    public List<Contact> findAll() {
        try {
            PreparedStatement statement = connection.prepareStatement(queryGetAll);
            ResultSet res = statement.executeQuery();
            Map<Integer, Contact> idToContacts = new HashMap<>();
            while (res.next()) {
                Integer id = res.getInt("id");
                if (idToContacts.containsKey(id)) {
                    idToContacts.get(id).addGroup(new Group(res.getString("name")));
                    continue;
                }
                Contact contact = new Contact();
                contact.setId(id);
                contact.setFirsName(res.getString("first_name"));
                contact.setLastName(res.getString("last_name"));
                contact.setEmail(res.getString("email"));
                contact.addGroup(new Group(res.getString("name")));
                idToContacts.put(id, contact);
            }
            return new ArrayList<>(idToContacts.values());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void getConnection(String propertyName) {
        String driverClass;
        String url;
        String user;
        String password;
        try {
            String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
            String path = rootPath + propertyName + ".properties";

            Properties dbProperties = new Properties();
            dbProperties.load(new FileInputStream(path));
            driverClass = dbProperties.getProperty("connection.driver_class");
            url = dbProperties.getProperty("connection.url");
            user = dbProperties.getProperty("connection.username");
            password = dbProperties.getProperty("connection.password");
            //Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
