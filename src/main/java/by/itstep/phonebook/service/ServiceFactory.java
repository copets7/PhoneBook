package by.itstep.phonebook.service;

import by.itstep.phonebook.service.impl.ContactServiceImpl;

public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance(){
        if (serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public ContactService getContactService(){
        return new ContactServiceImpl();
    }
}
