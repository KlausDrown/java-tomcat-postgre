<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>newVersion</title>
    <style>
        body{
            background-color: cornflowerblue;
        }
    </style>
</head>
<body>
<h1 align="center" style="font-size:50px;margin-top:23px;">Main Page</h1>


<h2 style="font-size:40px;margin-top:23px;margin-left:20px;">Add a user or company: </h2>
<div align="center" style="margin-top:23px;margin-left:45px;">

    <h3 style="font-size:30px;">Add user</h3>
    <form action="/newVersion" method="post">
        <table>


            <tr>
                <th>Email</th>
                <th>Name</th>
                <th>Password</th>
                <th>Company</th>
            </tr>

            <tr>
                <th>
        <label for="email">
            <input type="text" name="email" id="email">
        </label>
                </th>
                <th>
        <label for="name">
            <input type="text" name="name" id="name">
        </label>
                </th>
                <th>
        <label for="password">
            <input type="text" name="password" id="password">
        </label>
                </th>
                <th>
        <select name="selection">
            <option value="id" label="id"></option>
        </select>
                </th>
            </tr>
        </table>
        <input style="margin-top:10px" type="submit" name="sender" value="Send user data">
    </form>

    <h3 style="font-size:30px;">Add company</h3>
    <form action="/newVersion" method="post">
        <label for="companyName">Company name:
            <input type="text" name="companyName" id="companyName">
        </label></br>
        <input style="margin-top:10px" type="submit" name="sender" value="Send the company name">
    </form>
</div>

<h2 style="font-size:40px;margin-top:23px;margin-left:20px;">List of users and companies:</h2>
<div align="center" style="margin-top:23px;margin-left:45px;">


    <h3 style="font-size:30px;">User</h3>
    <div align="left"style="margin-left:20px;">
        <select style="font-size:20px;margin-left:30px;">
            <option value="" label="Select the users page"></option>
        </select>
        <h4>hello</h4>
        <h4>world</h4>
    </div>
    <h3 style="font-size:30px;">Company</h3>
    <div align="left" style="margin-left:20px;">
        <select style="font-size:20px;margin-left:30px;">
            <option value="" label="Select the company page"></option>
        </select>
        <h4>hello</h4>
        <h4>world</h4>
    </div>


</div>



</body>
</html>
