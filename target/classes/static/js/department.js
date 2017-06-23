var app = angular.module('departmentApp', []);
app.controller('myCtrl', ['$scope','$http', function($scope,$http) {
    
    $http({
        method: 'GET',
        url: '/api/getAllDepartment'
    }).then(
        function (successRes) {
            $scope.departments = successRes.data;
        },
        function (errorRes) {
            console.log(errorRes);
        }
    )
    $scope.deleteDepartment = function (departmentID) {
        $http({
            method: 'POST',
            url: '/api/removeDepartment?id=' + departmentID
        }).then(
            function (successRes) {
                var index = 0;
                for (var i=0; i<$scope.departments.length; i++) {
                    if ($scope.departments[i].id == departmentID) {
                        index = i;
                        break;
                    }
                }
                $scope.departments.splice(index, 1);
            },
            function (failRes) {
                console.log(failRes);
            }
        )
    }
    
    $scope.index = 0;
    $scope.list = [{
        'index': $scope.index,
        'class': 'glyphicon glyphicon-plus'
    }];
    $scope.addAction = function(index) {
        if (index == $scope.list.length - 1) {
            $scope.list[$scope.list.length - 1].class = 'glyphicon glyphicon-minus'
            $scope.list.push({
                'index': ++$scope.index,
                'class': 'glyphicon glyphicon-plus'
            });
        } else {
            $scope.list.splice(index, 1);
        }
    }

    $scope.submitDepartment = function() {
        var departments = [];
        $('.form-group').each(function() {
            var department = $(this).find('input').val();
            if (department) {
                departments.push(department);
            }
        })

        $("body").mLoading({
            text:"正在提交...",//加载文字，默认值：加载中...
            // icon:"",//加载图标，默认值：一个小型的base64的gif图片
            html:false,//设置加载内容是否是html格式，默认值是false
            // content:"",//忽略icon和text的值，直接在加载框中显示此值
            mask:true//是否显示遮罩效果，默认显示
        });

        $http({
            method: 'POST',
            url: '/api/addDepartment?names='+departments
        }).then(
            function (successRes) {
                $("body").mLoading("hide");//隐藏loading组件
                window.location.reload(true);
            },
            function (failRes) {
                $("body").mLoading("hide");//隐藏loading组件
            }
        );
    }
}]);

