<%--
  Created by IntelliJ IDEA.
  User: Galabut
  Date: 16.01.2015
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> TAXI OPERATOR LOGIN</title>
</head>
<body>
<h1> ${greeting} </h1>
<h1> ${greetingNEW} </h1>
<h1> ${success} </h1>

<a href="index.jsp">Log out</a>

Make your choice:
<href>
    log out
</href>
<form action="/Client" method="get"/>
<table>
    <tr>
        <td>
            <input type="submit" name="Clientreport" value="Register New Client" id="1">
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" name="Clientreport" value="Show Clients by Portion" id="2">
        </td>
        <td>
            <input type="text" name="portion" value="portion" id="portion">
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" name="Clientreport" value="Show Clients by SUM" id="3">
        </td>
        <td>
            <input type="text" name="sum" value="sum" id="sum"></td>
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" name="Clientreport" value="Show Clients of Last Month" id="4">
        </td>
    </tr>
</table>

</body>
</html>
