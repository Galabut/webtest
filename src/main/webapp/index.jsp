<%--
  Created by IntelliJ IDEA.
  User: Galabut
  Date: 16.01.2015
  Time: 22:27
  To change this template use File | Settings | File Templates.
  добавляем проверку на аутентификацию, авторизацию, добавление клиентов, добавление заказов. Сделать черех ajax
  ввести понятие "обязательное поле" и писать то не так, то не то
  Добавить панель администратора, с возмжностью добавления и редактирования пользователей системы.
  В самом верху появляется шапка с полями Добавить клиента, Редактировать клиента.
  Добавляется понятие роли.
  И при логине теперь уже определяем кто он, оператор или администратор
  И если заходит админ, то у него есть два доп. поля добавить или отредактировать оператора


--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> TAXI OPERATOR LOGIN
    <title>Operator LOG IN</title>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/my_query.js"></script>
</head>
<style>
    .colorText {
        background-color: #ffe; /* Цвет фона */
        color: #930; /* Цвет текста */
    }
</style>
<body onload="show()">


<script>
    /*   function func() {
     }
     function function1(arg) {
     document.write(arg)
     return true;
     }
     var res=function1(1,2,3);
     var res1=func(1,2,3);
     var res2=func();
     document.write('Hello Script');
     console.log('Special for log');
     var sentence = new Array(' Puff', 'of', 'red', 'hot', 'air', 'flavoured', 'with', 'lemon', 'peelings', 'soft-coal', 'smoke', 'and', 'train', 'oil', 'came', 'in', 'through', 'the', 'half-open', 'windows')
     var length = sentence[0].length;
     for (var i = 0; i < sentence.length; i++) {
     if (sentence[i].length >= length) {
     var word = sentence[i];
     document.write(word + ' ')
     i++;
     }
     }*/
</script>
<h2 onclick="func(1)"> Hey!
</h2>
${error}
<a href="Register.jsp">
    <li>to create new OPERATOR</li>
</a>


<form action="/auth" method="post"/>
<table>
    <tr>
        <td>
            <input type="text" name="login" value="login" class="colorText" id="loginID"/>
        </td>
    </tr>
    <tr>
        <td>
            <input type="text" name="password" value="password" class="colorText" id="passwordID"/>
        </td>
    </tr>
</table>
<input type="submit" value="enter" id="submit"/>

<div id="main">
    <script>
        function power(base, exponent) {
            if (exponent == undefined)
                exponent = 2;
            var result = 1;
            for (var count = 0; count < exponent; count++) {
                result *= base;
            }
            return result;
        }
        document.write(power(4));
        document.write(power(4, 3));</script>
</div>

<!--<script>
    var ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && status == 200) {
            console.log('ajax=' + ajax.responseText);
            document.getElementById('log').value = ajax.responseText;
        }
    }

    function clickFirstButton() {
        var login = document.getElementById("loginID");
        var password = document.getElementById("loginID");
        if (login.length == 0) {
            login.innerHTML = "Login is empty"
            alert('Error');
            return false;
        }
        if (password.length == 0) {
            password.innerHTML = "Password is empty";
            alert('Error');
            return false;
        }


    }
    </script>-->
<div id="block1">
    Красный цвет на белом
</div>

<div id="block2">
    Желтая рамка с зеленым текстом
</div>

<div id="block3">
    <table>
        <tbody id="Mytable">
        <tr>
            <td>User</td>
            <td>Password</td>
        </tr>
        </tbody>
    </table>
</div>


</body>
</html>
