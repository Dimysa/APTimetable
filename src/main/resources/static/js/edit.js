$(document).ready(function () {
    $.ajax({
        url: '/TypeOfLoad',
        async: false,
        timeout: 30000,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            fillTypeLoadSelect(data);
        }
    });
    $.ajax({
        url: '/Disciplines?' + "idFaculty=" + sessionStorage.getItem("idFaculty") + "\u0026semester=" + sessionStorage.getItem("semester"),
        type: 'GET',
        async: false,
        timeout: 15000,
        dataType: 'json',
        success: function (data) {
            fillDiscSelect(data);
        }
    });
    $.ajax({
        url: 'Teachers/',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            fillTeachersSelect(data);
        }
    })
});
$("#typeLoad").change(function () {
    if($("#typeLoad").val() == "ЛК") {
        $(".nonLection").css({'display': 'none'});
        $(".lection").css({'display': 'block'});
    } else {
        $(".lection").css({'display': 'none'});
        $(".nonLection").css({'display': 'block'});
    }
    var req = $("#typeLoad").val();
    $("#stream").html("");
    $("#specialty").html("");
    $("#group").html("");
    $("#subgroup").html("");
    $.ajax({
        url: '/Auditoriums?type=' + req,
        type: 'GET',
        dataType: 'json',
        success: function (msg) {
            fillAuditorium(msg);
        }
    });
    req = "idFaculty=" + sessionStorage.getItem("idFaculty") + "\u0026semester=" + sessionStorage.getItem("semester") + "\u0026load=" + $("#typeLoad").val();
    $.ajax({
        url: 'Load?' + req,
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
$("#specialty").change(function () {
    let req = "nameSpec="+$("#specialty option:selected").text() + "\u0026semester=" + sessionStorage.getItem("semester");
    sendReqForGroup(req);
});
$("#group").change(function () {
    let req = "nameSpec="+$("#specialty option:selected").text() + "\u0026semester=" + sessionStorage.getItem("semester") + "\u0026group=" + $("#group").val();
   sendReqForSubgroup(req);
});
$("#postTimetable").click(function () {
    let req = "day=" + $("#date").val() + "\u0026idClass=" + $("#numberClass").val() + "\u0026numberOfWeek=" + $("#numberOfWeek").val();
   let body = {
       numberOfAuditorium: $("#auditorium").val(),
       idOfDiscipline: $("#discipline").val(),
       typeOfLoad: $("#typeLoad").val(),
       idOfStream: $("#stream").val(),
       codeOfSpecilaty: $("#specialty").val(),
       group: $("#group").val(),
       subgroup: $("#subgroup").val(),
       semester: sessionStorage.getItem("semester"),
       idOfTeacher: $("#teachers").val()
   };
   $.ajax({
       url: '/Timetable?' + req,
       type: 'POST',
       contentType: 'application/json; charset:utf-8',
       data: JSON.stringify(body),
       success: function (data) {
           alert('Saved');
       }
   });
});
function loadInfoParams() {
    let req = "nameDiscipline=" + $("#discipline option:selected").text() + "\u0026semester=" + sessionStorage.getItem("semester");
    if($("#typeLoad").val() == "ЛК") {
        $.ajax({
            url: 'Stream?' + req,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                fillStream(data);
            }
        });
    }
    else {
        $.ajax({
            url: 'Specialties?' + req,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                fillSpecialties(data);
                req = "nameSpec="+$("#specialty option:selected").text() + "\u0026semester=" + sessionStorage.getItem("semester");
                sendReqForGroup(req);
            }
        });
    }
}
function sendReqForGroup(req) {
    $.ajax({
        url: 'Group?' + req,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            fillGroup(data);
            req = "nameSpec="+$("#specialty option:selected").text() + "\u0026semester=" + sessionStorage.getItem("semester") + "\u0026group=" + $("#group").val();
            sendReqForSubgroup(req);
        }
    });
}
function sendReqForSubgroup(req) {
    $.ajax({
        url: 'Subgroup?' + req,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            fillSubgroup(data);
        }
    });
}
function fillTeachersSelect(data) {
    let strRes = "";
    $.each(data, function (index, item) {
        let teacher = item.lastName + " " + item.firstName + " " + item.middleName;
        strRes += "<option value = " + item.id + ">" + teacher +  "</option>";
    });
    $("#teachers").html(strRes);
}
function fillSubgroup(data) {
    var strRes = "";
    $.each(data, function (index, item) {
        strRes += "<option value = " + item.subgroup + ">" + item.subgroup +  "</option>";
    });
    strRes += "<option value = " + "null" + ">" + "All" +  "</option>";
    $("#subgroup").html(strRes);
}
function fillGroup(data) {
    var strRes = "";
    $.each(data, function (index, item) {
        strRes += "<option value = " + item.group + ">" + item.group +  "</option>";
    });
    strRes += "<option value = " + "null" + ">" + "All" +  "</option>";
    $("#group").html(strRes);
}
function fillSpecialties(data) {
    var strRes = "";
    $.each(data, function (index, item) {
        strRes += "<option value = " +"\"" + item.codeOfSpecialty + "\"" + ">" + item.shortNameOfSpecialty +  "</option>";
    });
    $("#specialty").html(strRes);
}
function fillStream(data) {
    var strRes = "";
    $.each(data, function (index, stream) {
        strRes += "<option value = " + stream.id + ">" + stream.name +  "</option>";
    });
    $("#stream").html(strRes);
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