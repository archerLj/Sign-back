var app = angular.module('statisticsApp', []);
app.controller('statisticsCtrl', ['$scope', function($scope) {
    $scope.department = '部门';
    $scope.departments = ['人事部', '电商部', '软件部'];
    $scope.dropDownClick = function(index) {
        $scope.department = $scope.departments[index];
        $('.dropdown').css('margin-top', '0px');
        $('.hiddenFirst').removeAttr('hidden');
    }
    $scope.signLateClick = function(index) {
        $scope.signHistoryModalTitle = '迟到';
        $scope.staffName = $scope.staffList[index].name;
        $('#signHistory').modal()
    }
    $scope.signEarlyClick = function(index) {
        $scope.signHistoryModalTitle = '早退';
        $scope.staffName = $scope.staffList[index].name;
        $('#signHistory').modal()
    }

    $scope.signTimes = [
        '2017-05-01 09:31',
        '2017-05-03 10:32',
        '2017-05-04 12:33',
        '2017-05-01 09:34',
        '2017-05-03 15:35',
        '2017-06-04 12:36',
        '2017-05-05 09:37',
        '2017-05-03 10:08',
        '2017-05-04 12:39',
        '2017-07-01 09:31',
        '2017-07-03 10:32',
        '2017-07-04 12:33',
        '2017-07-01 09:34',
        '2017-07-03 15:35',
        '2017-07-04 12:36',
        '2017-07-05 09:37',
        '2017-07-03 10:08',
        '2017-07-04 12:39',
    ]
    $scope.staffList = [{
        'name': 'Jerry',
        'signIn': 10,
        'signQuit': 30,
        'signOut': 2,
        'signLate': 4,
        'signEarly': 12
    },
        {
            'name': 'Jerry',
            'signIn': 10,
            'signQuit': 30,
            'signOut': 2,
            'signLate': 4,
            'signEarly': 12
        },
        {
            'name': 'Jerry',
            'signIn': 10,
            'signQuit': 30,
            'signOut': 2,
            'signLate': 4,
            'signEarly': 12
        },
        {
            'name': 'Jerry',
            'signIn': 10,
            'signQuit': 30,
            'signOut': 2,
            'signLate': 4,
            'signEarly': 12
        },
        {
            'name': 'Jerry',
            'signIn': 10,
            'signQuit': 30,
            'signOut': 2,
            'signLate': 4,
            'signEarly': 12
        }
    ]
}])

