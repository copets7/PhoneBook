package by.itstep.phonebook.controller.impl;

import by.itstep.phonebook.controller.ContactController;
import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.service.ContactService;
import by.itstep.phonebook.service.ServiceException;
import by.itstep.phonebook.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://javarush.ru/groups/posts/328-sozdanie-prostogo-veb-prilozhenija-na-servletakh-i-jsp-chastjh-1
//https://javarush.ru/groups/posts/356-sozdanie-prostogo-veb-prilozhenija-na-servletakh-i-jsp-chastjh-2

//https://www.baeldung.com/tomcat-deploy-war2
public class ContactControllerServletImpl extends HttpServlet implements ContactController {

    private ContactService contactService;

    public ContactControllerServletImpl() {
        super();
        this.contactService = ServiceFactory.getInstance().getContactService();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI().substring(req.getRequestURI().lastIndexOf('/') + 1);
        RequestDispatcher requestDispatcher;

        if (path.equals("list")){
            requestDispatcher = req.getRequestDispatcher("views/list.jsp");
            req.setAttribute("contacts", getAll());
        } else {
            requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        }
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void createContact(Contact contact) throws ServiceException {
        contactService.createContact(contact);
    }

    @Override
    public List<Contact> getAll(){
        return contactService.getAll();
    }

    @Override
    public void deleteContact(Contact contact) {

    }

    @Override
    public void findContact(String phone) {

    }

    @Override
    public Set<Contact> findByName(String lastName) {
        return null;
    }
}
