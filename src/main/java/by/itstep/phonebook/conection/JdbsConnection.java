package by.itstep.phonebook.conection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class JdbsConnection {

    private static Connection conn;

    //TODO think of new solution

    public static Connection getConnection(String propertyName) {
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
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(){
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
