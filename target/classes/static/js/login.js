var app = angular.module('myApp',[]);
app.controller('myCtrl', ['$scope', '$http', function ($scope, $http) {
    $scope.login = function () {
        $("body").mLoading({
            text:"登录中...",//加载文字，默认值：加载中...
            // icon:"",//加载图标，默认值：一个小型的base64的gif图片
            html:false,//设置加载内容是否是html格式，默认值是false
            // content:"",//忽略icon和text的值，直接在加载框中显示此值
            mask:true//是否显示遮罩效果，默认显示
        });
        // $("body").mLoading("show");
        $http({
            method: 'POST',
            url: '/api/selectManager?name='+$scope.username + "&password="+hex_md5($scope.password)
        }).then(
            function (successRes) {
                $("body").mLoading("hide");//隐藏loading组件
                window.location.href='index.html'
            },
            function (failRes) {
                $("body").mLoading("hide");//隐藏loading组件
            }
        )
    }

    $scope.signIn = function () {
        $(element).mLoading("hide");//隐藏loading组件
        console.log($scope.myForm.$valid);
    }

    $scope.formValid = function () {
        return $scope.myForm.$valid;
    }
    
    $scope.$watch($scope.formValid, function (newValue, oldValue) {
        if (newValue) {
            $('#loginBtn').removeAttr("disabled");
        } else {
            $('#loginBtn').attr("disabled", "disabled")
        }
    })
}]);