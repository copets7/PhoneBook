package by.itstep.phonebook.controller.impl;

import by.itstep.phonebook.controller.ContactController;
import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.service.ContactService;
import by.itstep.phonebook.service.ServiceException;
import by.itstep.phonebook.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

//https://javarush.ru/groups/posts/328-sozdanie-prostogo-veb-prilozhenija-na-servletakh-i-jsp-chastjh-1
//https://javarush.ru/groups/posts/356-sozdanie-prostogo-veb-prilozhenija-na-servletakh-i-jsp-chastjh-2
public class ContactControllerServletImpl extends HttpServlet implements ContactController {

    private ContactService contactService;

    public ContactControllerServletImpl() {
        super();
        this.contactService = ServiceFactory.getInstance().getContactService();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI().substring(req.getRequestURI().lastIndexOf('/') + 1);
        RequestDispatcher requestDispatcher = (path.equals("list")) ?
                req.getRequestDispatcher("views/list.jsp") : req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        Set<String> phones = new HashSet<>();
        phones.add(phone);
        Contact contact = new Contact(firstName, lastName, phones, email, null);
        try {
            createContact(contact);
        } catch (ServiceException e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void createContact(Contact contact) throws ServiceException {
        contactService.createContact(contact);
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
