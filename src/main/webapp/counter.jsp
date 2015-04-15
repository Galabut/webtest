<%--
  Created by IntelliJ IDEA.
  User: Galabut
  Date: 23.12.2014
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="1">
<%! int counter = 0;
%>
<tr>
    <td>
    <%
        out.println(counter++);
    %></td>
</tr>
</table>
</body>
</html>
