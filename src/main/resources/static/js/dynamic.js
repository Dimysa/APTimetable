$(document).ready(function () {  
        if(window.location.pathname.split("/")[1] == 'security')
        $('#login').text = 'Admin';
    let temp = window.location.pathname.split('/');
    let myUrl = '/' + temp[1] + '/' + temp[2].replace(temp[2].charAt(0), temp[2].charAt(0).toUpperCase());
    var fields = [];
    $.ajax({
        url: myUrl,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            $.each(data, function (index, item) {
                let name;
                let tempTr = '<tr>';
                fields = [];
                for (name in item) {
                    fields.push(name);
                    tempTr += '<td class="' + name + '"><input type="text" value="' + item[name] + '" class="form-control"/></td>';
                }                
                tempTr += '<td><span class="glyphicon glyphicon-minus addBtnRemove"></span></td>' +
                    '</tr>';                    
                $('#tableAddRow tbody').append(tempTr); 
            }); 
            $.each(fields, function (index, item) {
                $('.col-head').append('<th>' + item + '</th>');
            })         
            $('.col-head').append('<th style="width:10px"><span class="glyphicon glyphicon-plus addBtn" id="addBtn_0"></span></th>');            
        }
    });
    $('thead').on('click', '.addBtn', function () {
        //var trID;
        //trID = $(this).closest('tr'); // table row ID 
        addTableRow();
    });
    $('tbody').on("click", 'span', function () {
        if($(this).closest('tr').attr('class') == undefined)
            $(this).closest('tr').attr('class', "bg-danger");  
        else
            if($(this).closest('tr').attr('class') != "bg-danger")
                $(this).closest('tr').remove();  
    });    
    $('tbody').on("input", "input[type='text']", function () {
        if($(this).closest('tr').attr('class') != 'bg-success') {
            $(this).closest('tr').attr('class', 'bg-warning')
        }
    });
    $('#submitDate').click(function () {
        $('tbody tr[class ^= "bg"]').each(function (index, elem) {
            if($(elem).attr("class") == "bg-success" || $(elem).attr("class") == "bg-warning") {
                let body = '{';
                $.each(fields, function (index, item) {
                    body += '"' + item + '":"' + $(elem).find('td.'+item+' input').val() + '",';
                });
                body = body.slice(0, -1) + '}';                
                $.ajax({
                    url: myUrl,
                    type: 'PUT',
                    contentType: 'application/json; charset:utf-8',
                    data: body,
                    error: function () {
                        alert('Error');
                    },
                    success: function () {
                        $(elem).removeAttr("class");
                    }
                });
            } else {
                $.ajax({
                    url: myUrl + '/' + $(elem).find('td.'+ fields[0] + ' input').val(),
                    type: 'DELETE',
                    error: function () {
                        alert('Error');
                    },
                    success: function () {
                        $(elem).remove();                        
                    }
                });
            }
        });
    });
    function addTableRow()
    {         
        let tempTr = '<tr class="bg-success">';
        $.each(fields, function (index, field) {
            tempTr += '<td class="' + field + '"><input type="text" class="form-control"/></td>';
        })        
        tempTr += '<td><span class="glyphicon glyphicon-minus addBtnRemove"></span></td>' +
            '</tr>';
        $("#tableAddRow tbody").append(tempTr);        
    }
});