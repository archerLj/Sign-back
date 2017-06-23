var app = angular.module('otherSettingApp', []);
app.controller('myCtrl', ['$scope', '$http', function ($scope, $http) {

    $scope.settingId = null;

    $http({
        method: 'GET',
        url: '/api/getSetting'
    }).then(
        function (successRes) {
            $scope.settingId = successRes.data.id;
            $scope.signInPlaceholder = successRes.data.workTime ? successRes.data.workTime :'请选择';
            $scope.signOutPlaceholder = successRes.data.offWorkTime ? successRes.data.offWorkTime : '请选择';
            $scope.checkDayPlaceholder = successRes.data.checkDay ? successRes.data.checkDay : '请选择';
        },
        function (failRes) {
            console.log(failRes);
        }
    )

    $scope.signInArr = [
        '07:00',
        '07:30',
        '08:00',
        '08:30',
        '09:00',
        '09:30',
        '10:00',
        '10:30',
        '11:00'
    ];

    $scope.signOutArr = [
        '15:00',
        '15:30',
        '16:00',
        '16:30',
        '17:00',
        '17:30',
        '18:00',
        '18:30',
        '19:00'
    ];

    $scope.checkDayArr = getAllCheckDay();

    $scope.singInTimeClick = function () {
        $scope.signInPlaceholder = $(this).attr('time');
    }
    $scope.singOutTimeClick = function () {
        $scope.signOutPlaceholder = $(this).attr('time');
    }
    $scope.checkDayClick = function () {
        $scope.checkDayPlaceholder = $(this).attr('time');
    }
    
    
    $scope.updateSetting = function () {
        if ($scope.signInPlaceholder == '请选择') {
            $scope.infoMessage = "请选择上班时间"
            $('#myModal').modal()
            return;
        } else if ($scope.signOutPlaceholder == '请选择') {
            $scope.infoMessage = "请选择下班时间"
            $('#myModal').modal()
            return;
        } else if ($scope.checkDayPlaceholder == '请选择') {
            $scope.infoMessage = "请选择每月考核日期"
            $('#myModal').modal()
            return;
        }

        $("body").mLoading({
            text:"提交中...",//加载文字，默认值：加载中...
            // icon:"",//加载图标，默认值：一个小型的base64的gif图片
            html:false,//设置加载内容是否是html格式，默认值是false
            // content:"",//忽略icon和text的值，直接在加载框中显示此值
            mask:true//是否显示遮罩效果，默认显示
        });

        var urlStr = "";
        if ($scope.settingId) {
            urlStr = '/api/updateSetting?id=' + $scope.settingId + '&workTime=' + $scope.signInPlaceholder + '&offWorkTime='
            + $scope.signOutPlaceholder + '&checkDay=' + $scope.checkDayPlaceholder;
        } else {
            urlStr = '/api/addSetting?workTime=' + $scope.signInPlaceholder + '&offWorkTime='
                + $scope.signOutPlaceholder + '&checkDay=' + $scope.checkDayPlaceholder;
        }
        $http({
            method: 'POST',
            url: urlStr
        }).then(
            function (successRes) {
                $("body").mLoading("hide");//隐藏loading组件
                console.log(successRes);
            },
            function (failRes) {
                $("body").mLoading("hide");//隐藏loading组件
                console.log(failRes);
            }
        )
    }
}])

function getAllCheckDay() {
    var list = [];
    for (var i=0; i<= 31; i++) {
        if (i < 10) {
            list.push('0' + i);
        } else {
            list.push(i);
        }
    }
    return list;
}