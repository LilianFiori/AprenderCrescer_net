
myApp.controller('ContaController', function ContaController($scope, $http, ContaFactory) {

    $scope.dados = [{"idconta": 1,
            "descricao": "Conta Corrente",
            "tipoconta": "Debito",
            "valor": 12.60,
     
        }];
     $scope.buscaConta = function(){
            ContaFactory.getConta( $scope.callbackConta);
     }

     $scope.callbackConta = function(resposta){
        $scope.dados = resposta.data;         
     }

})


