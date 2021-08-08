<%@ page import="java.util.List" %>
<%@ page import="by.itstep.phonebook.entity.Contact" %>
<%@ page import="jdk.nashorn.internal.ir.debug.JSONWriter" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/26/21
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contacts</title>
</head>

<body>
<div>
    <h1>Super app!</h1>
</div>

<div>
    <div>
        <div>
            <h2>Contacts</h2>
        </div>
        <%
            List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");

            if (contacts != null && !contacts.isEmpty()) {
                out.println("<ui>");
                for (Contact s : contacts) {
                    out.println("<li>" + s + "</li>");
                }
                out.println("</ui>");
            } else out.println("<p>There are no users yet!</p>");
        %>
    </div>
</div>

<div>
    <button onclick="location.href='phonebook-1.0/'">Back to main</button>
</div>
</body>
</html>
