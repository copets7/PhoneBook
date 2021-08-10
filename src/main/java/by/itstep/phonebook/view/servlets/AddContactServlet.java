package by.itstep.phonebook.view.servlets;

import by.itstep.phonebook.controller.ContactController;
import by.itstep.phonebook.controller.impl.ContactControllerImpl;
import by.itstep.phonebook.entity.Contact;
import by.itstep.phonebook.service.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


@WebServlet(
        name = "AddContactServlet",
        description = "JSP Servlet With Annotations",
        urlPatterns = {"/add"}
)
public class AddContactServlet extends HttpServlet {

    private  ContactController contactController = new ContactControllerImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");

        System.out.println(firstName);

        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        Set<String> phones = new HashSet<>();
        phones.add(phone);
        Contact contact = new Contact(firstName, lastName, phones, email, null);
        try {
            contactController.createContact(contact);
        } catch (ServiceException e) {
            throw new ServletException(e);
        }

        req.setAttribute("contactName", lastName);
        doGet(req, resp);
    }
}
