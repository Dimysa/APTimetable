$(document).ready(function () {
    $.ajax({
        url: '/security/TypeOfLoad',
        async: false,
        timeout: 30000,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            fillTypeLoadSelect(data);
        }
    });
    $.ajax({
        url: '/security/Disciplines?' + "idFaculty=" + sessionStorage.getItem("idFaculty") + "\u0026semester=" + sessionStorage.getItem("semester"),
        type: 'GET',
        async: false,
        timeout: 15000,
        dataType: 'json',
        success: function (data) {
            fillDiscSelect(data);
        }
    });
    $.ajax({
        url: '/security/Teachers',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            fillTeachersSelect(data);
        }
    })
    $("#typeLoad").change(function () {
        var req = $("#typeLoad").val();
        if(req == 'C')
            req = 'ПЗ';
        else if(req != 'ЛК' && req != 'ПЗ' && req != 'ЛР') {            
            $.ajax({
                url: '/security/Auditoriums',
                type: 'GET',
                dataType: 'json',
                success: function (msg) {
                    fillAuditorium(msg);
                }
            });
        } else {
            $.ajax({
                url: '/security/Auditoriums?type=' + req,
                type: 'GET',
                dataType: 'json',
                success: function (msg) {
                    fillAuditorium(msg);
                }
            });
        }
        req = "idFaculty=" + sessionStorage.getItem("idFaculty") + "\u0026semester=" + sessionStorage.getItem("semester") + "\u0026load=" + $("#typeLoad").val();
        $.ajax({
            url: '/security/Load?' + req,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                fillDiscSelect(data);
                loadInfoParams();
            }
        });
    });
    $("#discipline").change(function () {
        loadInfoParams();
    });
});
function loadInfoParams() {
    if ($("#discipline").val() == 108) {
        $.ajax({
            url: '/security/Auditoriums?type=' + 'Зал',
            type: 'GET',
            dataType: 'json',
            success: function (msg) {
                fillAuditorium(msg);
            }
        });
    }
}
function fillTeachersSelect(data) {
    let strRes = "";
    $.each(data, function (index, item) {
        let teacher = item.lastName + " " + item.firstName + " " + item.middleName;
        strRes += "<option value = " + item.id + ">" + teacher +  "</option>";
    });
    $("#teachers").html(strRes);
}
function fillTypeLoadSelect(data) {
    var strRes = "";
    $.each(data, function (index, typeLoad) {
        strRes += "<option value = " + typeLoad.shortNameOfLoad + ">" + typeLoad.shortNameOfLoad +  "</option>";
    });
    $("#typeLoad").html(strRes);
}
function fillAuditorium(data) {
    var strRes = "";
    $.each(data, function (index, auditorium) {
        strRes += "<option value = " + auditorium.numberOfAuditorium + ">" + auditorium.numberOfAuditorium +  "</option>";
    });
    $("#auditorium").html(strRes);
}
function fillDiscSelect(data) {
    var strRes = "";
    $.each(data, function (index, disc) {
        strRes += "<option value = " + disc.id + ">" + disc.nameOfDiscipline + "</option>";
    });
    $("#discipline").html(strRes);
}