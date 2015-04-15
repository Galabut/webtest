<%--
  Created by IntelliJ IDEA.
  User: Galabut
  Date: 03.02.2015
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    REGISTER CLIENT
    <title> NEW CLIENT</title>

    <h1> ${error} </h1>
</head>
<body>
<form action="/RegisterClient" method="post"/>
<table>

    <tr>
        <td>
            <input type="text" name="name" value="name" class="colorText"/>
        </td>
    </tr>
    <tr>
        <td>
            <input type="text" name="surname" value="surname" class="colorText"/>
        </td>
    </tr>
    <tr>
        <td>
            <input type="text" name="phone" value="phone" class="colorText"/>
        </td>
    </tr>
    <tr>
        <td>
            <input type="text" name="adress" value="adress" class="colorText"/>
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="enter"></td>
    </tr>

</table>

</body>
</html>
