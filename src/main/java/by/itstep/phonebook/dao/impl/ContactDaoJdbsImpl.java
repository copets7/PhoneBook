package by.itstep.phonebook.dao.impl;

import by.itstep.phonebook.conection.JdbsConnection;
import by.itstep.phonebook.dao.ContactDAO;
import by.itstep.phonebook.entity.Contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactDaoJdbsImpl implements ContactDAO {

    Connection connection;

    @Override
    public Contact save(Contact contact) {
        getConnection("database");
        if (connection != null) {
            Savepoint savepoint = null;
            List<String> values = Stream.of(contact.getFirsName(), contact.getLastName(), contact.getEmail(), contact.getPhones()).
                    map(String::valueOf).collect(Collectors.toList());
            String query = "INSERT INTO contact (first_name, last_name, email, phones) VALUES ('" + String.join("', '", values) + "')";
            try {
                savepoint = connection.setSavepoint();
                connection.setAutoCommit(false);
                PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                int id = statement.executeUpdate();
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
        List<Contact> contacts = new ArrayList<>();
        String query = "SELECT contact.id,  FROM contact INNER JOIN ON ";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet res = statement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contacts;
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
