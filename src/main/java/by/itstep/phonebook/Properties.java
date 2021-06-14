package by.itstep.phonebook;

import java.io.File;

public interface Properties {

    String ROOT_DIR = System.getProperty("user.dir") + File.separator + "db";
    String CONTACT_FILE_PATH = ROOT_DIR + File.separator+ "contacts.csv";

}
