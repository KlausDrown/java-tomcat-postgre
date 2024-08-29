<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ShowAll</title>
</head>
<body>
<h2>All Users</h2>
<table>
<tr><th>Login</th>            <th>Name</th>            <th>ID</th></tr>
<p><a href=index.jsp>home page</a></p>
    <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td>${user.email}---</td>           <td>---${user.name}---</td> <td>---${user.id}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>