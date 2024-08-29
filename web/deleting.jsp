<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove User</title>
</head>
<body>
<h2>Remove user</h2>
<a href=index.jsp>home page</a>
<form action="/deleting" method="post">
    <label for="Id">ID:
        <input type="number" name="Id" id="Id">
    </label><br/>
    <input type="submit" value="Send">
</form>
</body>
</html>
