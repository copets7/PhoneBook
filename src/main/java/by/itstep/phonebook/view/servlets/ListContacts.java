package by.itstep.phonebook.view.servlets;

import by.itstep.phonebook.controller.ContactController;
import by.itstep.phonebook.controller.impl.ContactControllerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        name = "ListContacts",
        description = "JSP Servlet With Annotations",
        urlPatterns = {"/list"}
)
public class ListContacts extends HttpServlet {

    ContactController contactController = new ContactControllerImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        req.setAttribute("contacts", contactController.getAll());
        requestDispatcher.forward(req, resp);
    }
}
