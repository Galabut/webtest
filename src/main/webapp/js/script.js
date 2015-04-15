$(document).ready(init);

function init() {
    $('#add').bind('click', show);
}
function show() {
    $.ajax({
        //dataType: 'json',
        //type: 'GET',
        url: '/ajax',
        success: function (jsondata) {
            alert(jsondata);
            for (var i=0;i,jsondata.length; i++) {

            }
            //alert(jsondata.name);
            //$('#results').html('Name = ' + jsondata.name + ', Nickname = ' + jsondata.nickname);
        },
        error: function (a, b, c) {
            alert(a + b + c);
        }
    });

    //alert($('#login').val());
    var login = $('#login').val();
    var pass = $('#pass').val();
    var tr = $('<tr></tr>');
    tr.append($('<td></td>').text(login));
    tr.append($('<td></td>').text(pass));

    /*    $('#table').append(tr);
     $('#one').css({background:"red", color:"white"});
     $('#two').css("border", "red");
     $('#two, #three').css("fontWeight", "bold");*/
}
