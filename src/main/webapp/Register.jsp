<%--
  Created by IntelliJ IDEA.
  User: Galabut
  Date: 20.01.2015
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>TAXI OPERATOR LOGIN
    <title>Operator LOG IN</title>

</head>

<body>

<form action="/RegisterServlet" method="get"/>

<h1> ${expiration} </h1>

<table>
    <tr>
        <td>
            <input type="text" name="login" value="login" class="colorText"/>
        </td>
    </tr>
    <tr>
        <td>
            <input type="text" name="id" value="id" class="colorText"/>
        </td>
    </tr>
    <tr>
        <td>
            <input type="text" name="password" value="password" class="colorText"/>
        </td>
    </tr>
    <tr>
        <td>
            <input type="text" name="password" value="password confirm" class="colorText"/>
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="enter"></td>
    </tr>

    <h1> ${error} </h1>

</table>
</form>
</body>
</html>
