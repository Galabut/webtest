/**
 * Created by Galabut on 31.01.2015.
 */


function show() {
    $('#test').css({color: "red", background: "white"});
    $('#block1').css({color: "red", background: "white"}); //Красный цвет на белом
    $('#block2').css({color: "green", background: "yellow", border: "1px solid red", bordercolor: "#FF9900"}); // Желтая рамка с зеленым текстом
    $('#block2, #block1').css("fontWeight", "bold");
    $('#submit').bind('click', onButtonClick);
    $('#tableForm').css({color: "green", background: "yellow", border: "1px solid red", bordercolor: "#FF9900"});
}
function onButtonClick() {
    var Login = $("#loginID").val();
    var Password = $("#passwordID").val();
    var tr = $('<tr><td>' + Login + '</td><td>' + Password + '</td></tr>');
    $('#Mytable').append(tr);
}

function sayHello() {
    var Login = $("#loginID").val();
    var str = "Hello" + Login;
}