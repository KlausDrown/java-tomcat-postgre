<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MainManagement</title>
    <style>
        body{
            background-color: cornflowerblue;
        }
        td {

            border: 3px solid grey;

        }
        #table1 {
            width: 100%;
            border: 3px solid grey;
            border-collapse: collapse;
            background-color: #4a6fb0;
        }
        #table2{
            width: 100%;
            border: 3px solid grey;
            border-collapse: collapse;
            background-color: #4a6fb0;

        }
    </style>
</head>
<body>
<h1 align="center" style="font-size:50px;margin-top:23px;">Main Page</h1>


<h2 style="font-size:40px;margin-top:23px;margin-left:20px;">Add a user or company: </h2>
<div align="center" style="margin-top:23px;margin-left:45px;">

    <h3 style="font-size:30px;">Add user</h3>
    <form action="/MainManagement" method="post">
        <table border="opx; ">


            <tr>
                <th>Email</th>
                <th>Name</th>
                <th>Password</th>
                <th>Department</th>
            </tr>

            <tr>
                <th>
        <label for="email">
            <input type="email" name="email" id="email">
        </label>
                </th>
                <th>
        <label for="name">
            <input type="text" name="name" id="name">
        </label>
                </th>
                <th>
        <label for="password">
            <input type="password" name="password" id="password">
        </label>
                </th>
                <th>
        <select name="selection" id="selection">
            <c:forEach var="department" items="${requestScope.departments}">
                <option value="${department.deptID}" label="${department.deptName}"></option>
            </c:forEach>
        </select>
                </th>
            </tr>
        </table>
        <input style="margin-top:10px" type="submit" name="sender" value="Send user data">
    </form>

    <h3 style="font-size:30px;">Add department</h3>
    <form action="/MainManagement" method="post">
        <label for="companyName">department name:
            <input type="text" name="companyName" id="companyName">
        </label></br>
        <input style="margin-top:10px" type="submit" name="sender" value="Send the department name">
    </form>
</div>

<h2 style="font-size:40px;margin-top:23px;margin-left:20px;">List of users and department:</h2>
<div align="center" style="margin-top:23px;margin-left:45px;">


    <h3 style="font-size:30px;">User</h3>
    <div align="left"style="margin-left:20px;">
        <form action="/MainManagement" method="post">
            <label>
                <input type="number" name="employeeDelete" id="employeeDelete">
                <input type="submit" name="sender" value="Delete an employee by id">
            </label>

        <select style="font-size:20px;margin-left:30px;">
            <option value="" label="Select the users page"></option>
        </select>
        <div>
        <table id="table1">
            <thead>
            <tr>
                <td>Employee ID</td>
                <td>Employee's name</td>
                <td>Employee's login</td>
                <td>Name of the employee's department</td>
            </tr>
            </thead>
            <tbody>
        <c:forEach var="employee" items="${requestScope.employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.login}</td>
                <td>${employee.department_name}</td>
            </tr>
        </c:forEach>
            </tbody>
        </table>

        </div>
        </form>
    </div>


    <h3 style="font-size:30px;">Department</h3>
    <div align="left" style="margin-left:20px;">
        <form action="/MainManagement" method="post">
            <label for="departmentDelete">
                <input type="number" name="departmentDelete" id="departmentDelete">
            </label>
                <input type="submit" name="sender" value="Delete a department by id">
        <select style="font-size:20px;margin-left:30px;">
            <option value="" label="Select the department page"></option>
        </select>
        <table id="table2">
            <thead>
            <tr>
                <td>Department ID</td>
                <td>Department name</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="department" items="${requestScope.departments}">
                <tr>
                    <td>${department.deptID}</td>
                    <td>${department.deptName}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </form>
    </div>


</div>



</body>
</html>
