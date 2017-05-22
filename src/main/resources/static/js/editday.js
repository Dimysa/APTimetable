var countTable = 0;
var codeSpec = 0;
var massSpec;
$(function () {
    $("#date").val(new Date);
    loadTable();
    $("#submitDate").click(function () {
    if(countTable == 0)
        loadInfoTimetable();
    else if(countTable == 1)
        loadInfoSpecTimetable();
    });
    $("#back-timetable").click(function () {
        countTable = 0;
        codeSpec = "";
        loadTable();
    });

    $('table').on("mouseenter mouseleave", 'td', function () {
        $(this).toggleClass('hovered')
    });
    $('table').on("click", 'td', function () {
        $(this).toggleClass('selected')
    });
    $('.edit-timetable').click(function () {
        if ($('.selected').length > 0) {
            if ($('.window').css('right') !== '0px') {
                $('.window').animate({'right': '0'}, function () {
                    $('.window').css('color', 'white');
                });
            } else {
                $('.window').css('color', 'rgba(4,4,4,0.0)').animate({'right': '-250px'});
            }
        } else {
            alert("Selected column in table");
        }

    });
    $('table').on("click", '.col-head', function () {
        $("#back-timetable").show();
        countTable = 1;
        codeSpec = $(this).attr('id');
        let nameSpec = $(this).text();
        $('.row-head').html("<td></td>");
        $('tbody tr td[class^=col]').remove();
        let req = "codeOfSpecialty=" + codeSpec + "\u0026semester=" + sessionStorage.getItem("semester");
        $.ajax({
            url: '/security/Subgroup?' + req,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                $.each(data, function (index, item) {
                    $('<td></td>').text(nameSpec + " " + item.group + "-" + item.subgroup).attr("id", item.group + "," + item.subgroup)
                        .appendTo(".row-head");
                    $('<td><div></div></td>').attr("id", item.group + "," + item.subgroup)
                        .attr("class", 'col-table').appendTo('tbody tr');
                })
                loadInfoSpecTimetable();
            }
        })
    });
    $("#postTimetable").click(function () {
        $('.selected').each(function (index, item) {
            let req = "day=" + $("#date").val() +
                "\u0026idClass=" + $(item).parent().attr('class') +
                "\u0026numberOfWeek=" + $(item).parent().attr("id").split(',')[1];
            var gr;
            var subgr;
            if (countTable == 0) {
                codeSpec = $(item).attr('id');
            } else {
                var str = $(item).attr('id');
                gr = str.split(',')[0];
                subgr = str.split(',')[1];
            }
            let body = {
                numberOfAuditorium: $("#auditorium").val(),
                idOfDiscipline: $("#discipline").val(),
                typeOfLoad: $("#typeLoad").val(),
                codeOfSpecialty: codeSpec,
                group: gr,
                subgroup: subgr,
                semester: sessionStorage.getItem("semester"),
                idOfTeacher: $("#teachers").val()
            };
            $.ajax({
                url: '/security/Timetable?' + req,
                type: 'PUT',
                contentType: 'application/json; charset:utf-8',
                data: JSON.stringify(body),
                error: function (data) {
                    alert('Error');
                }
            });
        });
        loadTable();
        $('.window').css('color', 'rgba(4,4,4,0.0)').animate({'right': '-250px'});
    });
    $("#deleteTimetable").click(function () {
        $('.selected').each(function (index, item) {
            let strId = $(item).children().attr("id");
            if(strId == undefined) {
                alert("Error");
                return;
            }
            var arrayId = strId.split(',');
            $.each(arrayId, function (ind, id) {
                $.ajax({
                    url: '/security/Timetable/' + id,
                    type: 'DELETE',
                    error: function () {
                        alert('err');
                    }
                })
            })
        })
        loadTable();
        $('.window').css('color', 'rgba(4,4,4,0.0)').animate({'right': '-250px'});
    });
    $("#updateTimetable").click(function () {
        $('.selected').each(function (index, item) {
            let strId = $(item).children().attr("id");
            if(strId == undefined) {
                alert("Error");
                return;
            }
            var arrayId = strId.split(',');
            var gr;
            var subgr;
            if (countTable == 0) {
                codeSpec = $(item).attr('id');
            } else {
                var str = $(item).attr('id');
                gr = str.split(',')[0];
                subgr = str.split(',')[1];
            }
            $.each(arrayId, function (ind, id) {
                let body = {
                    id: id,
                    numberOfAuditorium: $("#auditorium").val(),
                    idOfDiscipline: $("#discipline").val(),
                    typeOfLoad: $("#typeLoad").val(),
                    codeOfSpecialty: codeSpec,
                    group: gr,
                    subgroup: subgr,
                    semester: sessionStorage.getItem("semester"),
                    idOfTeacher: $("#teachers").val()
                };
                $.ajax({
                    url: '/security/Timetable/' + id,
                    type: 'POST',
                    contentType: 'application/json; charset:utf-8',
                    data: JSON.stringify(body),
                    error: function (data) {
                        alert('Error');
                    }
                });
            });
        });
        loadTable();
        $('.window').css('color', 'rgba(4,4,4,0.0)').animate({'right': '-250px'});
    });
});

function loadTable() {
    $('#back-timetable').hide();
    $('.row-head').html("<td></td>");
    $('tbody tr td[class^=col]').remove();
    massSpec = new Array();
    $.ajax({
        url: '/security/Specialties?idFaculty=' + sessionStorage.getItem('idFaculty'),
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            $.each(data, function (index, item) {
                massSpec.push(item.codeOfSpecialty);
                $('<td></td>').text(item.shortNameOfSpecialty).attr("id", item.codeOfSpecialty)
                    .attr("class", "col-head")
                    .appendTo(".row-head");
                $('<td><div></div></td>').attr("id", item.codeOfSpecialty).attr("class", "col-table").appendTo('tbody tr');
            });
            loadInfoTimetable();
        }
    });
}

function loadInfoTimetable() {
    $('td.col-table div').html("");
    $.each(massSpec, function (index, item) {
        let req = "codeSpec=" + item + "\u0026semester=" + sessionStorage.getItem("semester") +
            "\u0026startDate=" + $("#date").val() + "\u0026endDate=" + $("#date").val();
        $.ajax({
            url: '/ViewTimetable?' + req,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                $.each(data, function (ind, elem) {
                    let result = "";
                    if(elem.fullNameOfLoad == 'Лекция') {
                        result = elem.fullNameOfLoad +
                            "<br \>" + elem.nameOfDiscipline +
                            "<br \>" + elem.numberOfAuditorium +
                            "<br \>" + elem.lastName;
                        let id = $('table tbody tr[id $=' + (parseInt(elem.numberOfWeek) % 2) + '][class ^=' + elem.time.split('.')[0] + '] td[id="' + item + '"] div').attr("id");
                        if(id == undefined)
                            id = elem.id;
                        else
                            id += "," + elem.id;
                        $('table tbody tr[id $=' + (parseInt(elem.numberOfWeek) % 2) + '][class ^=' + elem.time.split('.')[0] + '] td[id="' + item + '"] div').attr("id", id);
                        $('table tbody tr[id $=' + (parseInt(elem.numberOfWeek) % 2) + '][class ^=' + elem.time.split('.')[0] + '] td[id="' + item + '"] div').html(result);
                    } else {
                        result += elem.fullNameOfLoad +
                            ": " + elem.groupNum +
                            "-" + elem.subgroup + "<br \>";
                        let id = $('table tbody tr[id $=' + (parseInt(elem.numberOfWeek) % 2) + '][class ^=' + elem.time.split('.')[0] + '] td[id="' + item + '"] div').attr("id");
                        if(id == undefined)
                            id = elem.id;
                        else
                            id += "," + elem.id;
                        $('table tbody tr[id $=' + (parseInt(elem.numberOfWeek) % 2) + '][class ^=' + elem.time.split('.')[0] + '] td[id="' + item + '"] div').attr("id", elem.id);
                        $('table tbody tr[id $=' + (parseInt(elem.numberOfWeek) % 2) + '][class ^=' + elem.time.split('.')[0] + '] td[id="' + item + '"] div').html(result);
                    }
                });
            }
        });
    });
}
function loadInfoSpecTimetable() {
    $('td.col-table div').html("");
    let req = "codeSpec=" + codeSpec + "\u0026semester=" + sessionStorage.getItem("semester") +
        "\u0026startDate=" + $("#date").val() + "\u0026endDate=" + $("#date").val();
    $.ajax({
        url: '/ViewTimetable?' + req,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            $.each(data, function (ind, elem) {
                let result = elem.fullNameOfLoad +
                    "<br \>" + elem.nameOfDiscipline +
                    "<br \>" + elem.numberOfAuditorium +
                    "<br \>" + elem.lastName;
                $('table tbody tr[id $=' + (parseInt(elem.numberOfWeek) % 2) + '][class ^=' + elem.time.split('.')[0] + '] td[id="' + elem.groupNum + "," + elem.subgroup + '"] div').attr("id", elem.id);
                $('table tbody tr[id $=' + (parseInt(elem.numberOfWeek) % 2) + '][class ^=' + elem.time.split('.')[0] + '] td[id="' + elem.groupNum + "," + elem.subgroup + '"] div').html(result);
            });
        }
    });
}