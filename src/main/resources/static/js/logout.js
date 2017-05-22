$(document).ready(function () {
    $(window).on('load', function () {
        if(window.location.pathname.split("/")[1] == 'security')
            $('#login').text('Admin');
        $('#login').attr('href', '/');
        $('body').on('click', '#btnLogin', function () {
            $.ajax({
                url: '/security/startedit',
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Authorization", "Basic " + btoa($('#inLogin').val() + ':' + $('#inPass').val()));
                },
                success: function () {
                    window.location.href = '/security/startedit';
                }
            })
        })
    });

})
