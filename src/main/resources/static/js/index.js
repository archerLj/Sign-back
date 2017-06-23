$(function() {
    $('#department-link').click(function() {
        $('.main-iFrame').attr('src', 'department.html');
        $('.navbar-collapse').collapse('hide');
    })

    $('#staff-link').click(function() {
        $('.main-iFrame').attr('src', 'staff.html');
        $('.navbar-collapse').collapse('hide');
    })

    $('#statistics-link').click(function() {
        $('.main-iFrame').attr('src', 'statistics.html');
        $('.navbar-collapse').collapse('hide');
    })

    $('#quit-link').click(function() {
        $('#logoutModal').modal();
    })

    $('#logoutButton').click(function() {
        window.location.href = 'login.html';
    })

    $('#other-setting').click(function () {
        $('.main-iFrame').attr('src', 'otherSetting.html');
        $('.navbar-collapse').collapse('hide');
    })
})
