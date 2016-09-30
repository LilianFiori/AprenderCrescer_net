
myApp.controller('ContaController', function ContaController($scope, $http, ContaFactory) {

    $scope.dados = [{"idconta": 1,
            "descricao": "nnnn",
            "valor": "",
            
        }];
     $scope.buscaGrupo = function(){
            GrupoFactory.getGrupo( $scope.callbackGrupo);
     }

     $scope.callbackGrupo = function(resposta){
        $scope.dados = resposta.data;         
     }

})


