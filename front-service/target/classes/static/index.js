angular.module('market-app', []).controller('indexController', function ($scope, $http) {
    console.log('web app started');

    const contextPath = 'http://localhost:8186/market/';

    $scope.loadProducts = function () {
        $http.get(contextPath + 'test_dto')
            .then(function (response) {
                console.log(response)
                $scope.products = response.data;

            });
    };

    $scope.loadStrings = function () {
        $http.get(contextPath + 'test_all')
            .then(function (response) {
                console.log(response)
                $scope.string_products = response.data;

            });
    };

}); 