function DayClick(dayNum, obj) {
    if ($(obj).hasClass('selected')) {
        $('#Schedule table tbody tr td.d' + dayNum).removeClass('selected');
        $(obj).removeClass('selected');
    }
    else {
        $('#Schedule table tbody tr td.d' + dayNum).addClass('selected');
        $(obj).addClass('selected');
    };
}
$(document).ready(function() {
    sessionStorage.setItem("incDate", 0);
    generateTable(new Date);
    getTimetable(new Date);
    $('#Schedule table tbody tr .d0').hover(
        function() { $('#Schedule table thead tr td.d0').addClass('hovered') },
        function() { $('#Schedule table thead tr td.d0').removeClass('hovered') });
    $('#Schedule table thead tr .d0').hover(
        function() { $('#Schedule table td.d0').addClass('hovered') },
        function() { $('#Schedule table td.d0').removeClass('hovered') })
            .click(function() { DayClick('0', this) });

    $('#Schedule table tbody tr .d1').hover(
        function() { $('#Schedule table thead tr td.d1').addClass('hovered') },
        function() { $('#Schedule table thead tr td.d1').removeClass('hovered') });
    $('#Schedule table thead tr .d1').hover(
        function() { $('#Schedule table td.d1').addClass('hovered') },
        function() { $('#Schedule table td.d1').removeClass('hovered') })
            .click(function() { DayClick('1', this) });

    $('#Schedule table tbody tr .d2').hover(
        function() { $('#Schedule table thead tr td.d2').addClass('hovered') },
        function() { $('#Schedule table thead tr td.d2').removeClass('hovered') });
    $('#Schedule table thead tr .d2').hover(
        function() { $('#Schedule table td.d2').addClass('hovered') },
        function() { $('#Schedule table td.d2').removeClass('hovered') })
            .click(function() { DayClick('2', this) });

    $('#Schedule table tbody tr .d3').hover(
        function() { $('#Schedule table thead tr td.d3').addClass('hovered') },
        function() { $('#Schedule table thead tr td.d3').removeClass('hovered') });
    $('#Schedule table thead tr .d3').hover(
        function() { $('#Schedule table td.d3').addClass('hovered') },
        function() { $('#Schedule table td.d3').removeClass('hovered') })
            .click(function() { DayClick('3', this) });

    $('#Schedule table tbody tr .d4').hover(
        function() { $('#Schedule table thead tr td.d4').addClass('hovered') },
        function() { $('#Schedule table thead tr td.d4').removeClass('hovered') });
    $('#Schedule table thead tr .d4').hover(
        function() { $('#Schedule table td.d4').addClass('hovered') },
        function() { $('#Schedule table td.d4').removeClass('hovered') })
            .click(function() { DayClick('4', this) });

    $('#Schedule table tbody tr .d5').hover(
        function() { $('#Schedule table thead tr td.d5').addClass('hovered') },
        function() { $('#Schedule table thead tr td.d5').removeClass('hovered') });
    $('#Schedule table thead tr .d5').hover(
        function() { $('#Schedule table td.d5').addClass('hovered') },
        function() { $('#Schedule table td.d5').removeClass('hovered') })
            .click(function() { DayClick('5', this) });

    $('#Schedule table tr').hover(
        function() { $(this).addClass('hovered') },
        function() { $(this).removeClass('hovered') });
    $('#Schedule table tbody tr td').click(
        function() { $(this).toggleClass('selected') });
    $("#btnNext").click(function () {
        let inc = parseInt(sessionStorage.getItem("incDate")) + 7;
        sessionStorage.setItem("incDate", inc);
        let date = new Date;
        date.setDate(date.getDate() + inc);
        generateTable(date);
        getTimetable(date);
    });
    $("#btnPrev").click(function () {
        let inc = parseInt(sessionStorage.getItem("incDate")) - 7;
        sessionStorage.setItem("incDate", inc);
        let date = new Date;
        date.setDate(date.getDate() + inc);
        generateTable(date);
        getTimetable(date);
    });
});

function SubmitSchedule() {
    var XMLSchedule = "";
    for (var d = 0; d < 6; d++) {        
        for (var h = 0; h < 7; h++) {
            if ($('#Schedule table tbody tr.h' + h + ' td.d' + d).hasClass('selected')) {
                XMLSchedule += 'd = ' + d + ' h = ' + h;
            }
            XMLSchedule += '\n'
        }        
    }
    $('#output').text(XMLSchedule);
}
function generateTable(currDate) {
    $.ajax({
        url: '/Time',
        type: 'GET',
        dataType: 'json',
        async: '15000',
        success: function (data) {
            fillTable(data, currDate);
        }
    });
}
function getTimetable(currDate) {
    let req = "&startDate=" + currDate.getWeekStartDate().getFormatDate() +
            "&endDate=" + currDate.getWeekEndDate().getFormatDate();
    $.ajax({
        url: 'ViewTimetable?codeSpec=' + sessionStorage.getItem('specialty') +
         '&semester=' + sessionStorage.getItem('semester') + req + 
         '&group=' + sessionStorage.getItem('group') + 
         '&subgroup=' + sessionStorage.getItem('subgroup'),
        type: 'GET',
        dataType: 'json',
        async: '15000',
        success: function (data) {
            fillTimetable(data, currDate);
        }
    });
}
function fillTimetable(data, currDate) {    
    let date = currDate.getWeekStartDate();
    for(let i = 0; i < 6; i++) {
        let strDate = date.getFormatDate();
        for(let j = 0; j < 7; j++) {
            $(".h" + j + " td.d" + i).html("");
            $(".h" + j + " td.d" + i).removeAttr("id");
            $.each(data, function (index, item) {
                if($("#session" + j).html() == item.time && item.date == strDate) {
                    let result = item.fullNameOfLoad +
                        "<br \>" + item.nameOfDiscipline +
                            "<br \>" + item.numberOfAuditorium +
                            "<br \>" + item.lastName;
                    $(".h" + j + " td.d" + i).html(result);
                    $(".h" + j + " td.d" + i).attr("id", item.id);
                }
            })
        }
        date.setDate(date.getDate() + 1);
    }
}
function fillTable(data, currDate) {
    let date = currDate.getWeekStartDate();
    for(let i = 0; i < 6; i++) {
        let mmdd = date.getDate() + "." + parseInt(date.getMonth() + 1);
        let str = ".headDay td.d" + i + " div";
        $(str).html(mmdd);
        date.setDate(date.getDate() + 1);
    }
    $.each(data, function (index, time) {
        $("#session" + index).html(time.time);
    });    
}

Date.prototype.getWeekDay = function() {
    var day = this.getDay();
    if(day==0) return 7;
    else return day;
};

// Returns current week start date
Date.prototype.getWeekStartDate = function() {
    var date = new Date(this.getTime());
    date.setDate(this.getDate()-(this.getWeekDay()-1));
    return date;
};

// Returns current week end date
Date.prototype.getWeekEndDate = function() {
    var date = new Date(this.getTime());
    date.setDate(this.getDate()+(7-this.getWeekDay()));
    return date;
};
Date.prototype.getFormatDate =  function() {
        var month = '' + (this.getMonth() + 1),
        day = '' + this.getDate(),
        year = this.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');
};