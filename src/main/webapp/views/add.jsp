<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/26/21
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>

<body>
<div>
    <h1>Super app!</h1>
</div>

<div>
    <div>
        <div>
            <h2>Add user</h2>
        </div>

        <form method="post">
            <label>First Name:
                <input type="text" name="firsName"><br />
            </label>
            <label>Last Name:
                <input type="text" name="lastName"><br />
            </label>
            <label>Email:
                <input type="text" name="email"><br />
            </label>
            <label>Phone:
                <input type="text" name="phone"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='phonebook-1.0/'">Back to main</button>
</div>
</body>
</html>
