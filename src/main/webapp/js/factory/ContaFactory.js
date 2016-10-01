'use strict'

myApp.factory('ContaFactory', ['$http', function ($http) {
        return{
            getConta: function (callback) {
                $http({"method": "GET", "url": "/AprenderCrescer/rest/conta/getcontas"}).then(
                        function (resposta) {
                            callback(resposta);
                            
                        });
            },
        };
    }]);



