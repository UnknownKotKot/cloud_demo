angular.module('market-app', []).controller('indexController', function ($scope, $http) {
    console.log('web app started');

    const contextPath = 'http://localhost:5555/product-service/market/api/v1/products';

    $scope.loadProducts = function () {
        $http.get(contextPath)
            .then(function (response) {
                console.log(response)
                $scope.products = response.data;
            });
    };
}); 