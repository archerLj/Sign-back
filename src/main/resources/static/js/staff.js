$(document).ready(function() {
    $('.nav-tabs').children("li:eq(0)").addClass('active');
    $('.tab-content').find('.tab-pane:eq(0)').addClass('active');
});

var app = angular.module('staff-app', []);
app.controller('staff-ctrl', ['$scope', function($scope) {
    $scope.departments = [{
        'departmentId': 'department0',
        'departmentName': '人事部'
    },
        {
            'departmentId': 'department1',
            'departmentName': '电商部'
        },
        {
            'departmentId': 'department2',
            'departmentName': '软件部'
        }
    ]

    $scope.departmentChange = function(index) {
        console.log(index);
    }

    $scope.deleteStaff = function(index) {

    }

    $scope.staffs = [{
        'name': '老刘',
        'jobNum': '1234',
        'phoneNum': '12433asdfasdfa',
        'position': 'Web开发工程师'
    },
        {
            'name': '老刘',
            'jobNum': '1234',
            'phoneNum': '12433asdfasdf',
            'position': 'Web开发工程师'
        },
        {
            'name': '老刘',
            'jobNum': '1234',
            'phoneNum': '12433asfasdfasdf',
            'position': 'Web开发工程师'
        },
        {
            'name': '老刘',
            'jobNum': '1234',
            'phoneNum': '12433asdfsadfsadf',
            'position': 'Web开发工程师'
        },
        {
            'name': '老刘',
            'jobNum': '1234',
            'phoneNum': '12433asdfasdfasdf',
            'position': 'Web开发工程师'
        },
        {
            'name': '老刘',
            'jobNum': '1234',
            'phoneNum': '12433asdfasdf',
            'position': 'Web开发工程师'
        }
    ]
}]);

