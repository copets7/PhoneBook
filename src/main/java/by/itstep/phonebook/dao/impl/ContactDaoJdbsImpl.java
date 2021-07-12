package by.itstep.phonebook.dao.impl;

import by.itstep.phonebook.conection.JdbsConnection;
import by.itstep.phonebook.dao.ContactDAO;
import by.itstep.phonebook.entity.Contact;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactDaoJdbsImpl implements ContactDAO {

    @Override
    public Contact save(Contact contact) {
        Connection connection = JdbsConnection.getConnection("database");
        if (connection != null){
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
                JdbsConnection.closeConnection();
            }
        }
        return null;
    }
}
