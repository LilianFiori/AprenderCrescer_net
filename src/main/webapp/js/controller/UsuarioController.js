
myApp.controller('UsuarioController', function UsuarioController($scope, $http, UsuarioFactory) {

    $scope.editando = false;

    $scope.dados = [{"IdUsuario": 1,
            "IdGrupo": 1,
            "Login": "Lilian",
            "Nome": "Lilian Fiori",
            "Atvio": "F"

        }];
    $scope.buscaUsuarios = function () {
        UsuarioFactory.getUsuarios($scope.callbackUsuarios);
    }

    $scope.callbackUsuarios = function (resposta) {
        $scope.dados = resposta.data;
    }

    $scope.editarUsuario = function () {
        $scope.editando = !$scope.editando;
    }

    $scope.cadastroUsuario = function (usuario) {
        UsuarioFactory.setUsuario($scope.callbackCadastroUsuario, usuario);
    }

    $scope.callbackCadastroUsuario = function (resposta) {
        if (resposta.status != 200) {
            swal("Usuario", "Erro no cadastro do usuario" , "error");
        } else {
            
            swal("Usuario", "Usuario Cadastrado com sucesso!", "success");
            $scope.buscaUsuarios();
            $scope.limpaCampos();
        }
    }
    $scope.limpaCampos = function () {
        $scope.usuario.nome = "";
        $scope.usuario.login = "";
        $scope.usuario.atvio = "";
        $scope.usuario.idGrupo = "";
        $scope.usuario.idUsuario = "";
        




    }
})

