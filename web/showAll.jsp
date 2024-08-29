<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ShowAll</title>
</head>
<body>
<h2 align="center">All Users</h2>
<h3>Available pages: ${numbOfPage} ---</h3>
<select onchange="window.location.href = this.options[this.selectedIndex].value">
    <option value="" label="select a page"></option>
    <c:forEach var="pager" items="${requestScope.selectPage}">
        <option value="?pag=${pager}" label="page: ${pager}"> page${pager}</option>
    </c:forEach>
</select>
<h2>Your page: ${param.pag}</h2>
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