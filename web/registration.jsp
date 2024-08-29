<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration</title>
</head>
<body>
<h2>Add user</h2>
<a href=index.jsp>home page</a>
<form action="/registration" method="post">
    <label for="email">Email:
        <input type="email" name="email" id="email">
    </label><br/>
    <label for="name">Name:
        <input type="text" name="name" id="name">
    </label><br/>
    <label for="password">Password:
        <input type="password" name="password" id="password">
    </label><br/>
<input type="submit" value="Send">
</form>
</body>
</html>
