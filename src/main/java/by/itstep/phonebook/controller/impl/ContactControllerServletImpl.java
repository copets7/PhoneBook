package by.itstep.phonebook.controller.impl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContactControllerServletImpl extends HttpServlet {
//https://javarush.ru/groups/posts/328-sozdanie-prostogo-veb-prilozhenija-na-servletakh-i-jsp-chastjh-1
//https://javarush.ru/groups/posts/356-sozdanie-prostogo-veb-prilozhenija-na-servletakh-i-jsp-chastjh-2
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }


}
