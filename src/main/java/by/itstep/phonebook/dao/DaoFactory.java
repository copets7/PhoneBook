package by.itstep.phonebook.dao;

import by.itstep.phonebook.dao.impl.ContactDAOImpl;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public ContactDAO getContactDAO(){
        return new ContactDAOImpl();
    }
}
