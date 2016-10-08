
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

    $scope.editarUsuario = function (item) {
        $scope.editando = true;
        /*
         $scope.usuario.nome = item.nome;
         $scope.usuario.login = item.login;
         $scope.usuario.flagInativo = item.flagInativo;
         $scope.usuario.idGrupo = item.idGrupo;
         $scope.usuario.idUsuario = item.idUsuario;
         $scope.usuario.senha = item.senha;
         */

        $scope.usuario = angular.copy(item);

    }

    $scope.cadastroUsuario = function (usuario) {

        if (usuario.idUsuario && usuario.idUsuario != 0) {
            UsuarioFactory.updateUsuario($scope.callbackCadastroUsuario, usuario);
        } else {
            UsuarioFactory.setUsuario($scope.callbackCadastroUsuario, usuario);
        }
    }
    $scope.callbackCadastroUsuario = function (resposta) {
        if (resposta.status != 200) {
            if ($scope.editando == true) {
                swal("Usuario", "Erro ao atulizar o usuario", "error");
            } else {
                swal("Usuario", "Erro ao cadastrar o usuario", "error");
            }
        } else {
            if ($scope.editando == true) {
                swal("Usuario", "Usuario salvo com sucesso", "success");
            } else {
                swal("Usuario", "Usuario Cadastrado com sucesso!", "success");
            }
            $scope.buscaUsuarios();
            $scope.limpaCampos();
        }
    }
    $scope.limpaCampos = function () {
       var usuario = {idUsuario: "", nome: "", login: "", flagInativo: "", idGrupo: "", senha: ""
       }
        $scope.usuario = usuario;
        $scope.editando = false;
    }

    $scope.deleteUsuario = function (usuario) {
        UsuarioFactory.deleteUsuario($scope.callbackDeleteUsuario, usuario);
    }
    $scope.callbackDeleteUsuario = function (resposta) {
       if(resposta.status != 200){
           swal("Usuario", "Erro ao deletar o usuario", "error");
       }else{
           swal("Usuario", "Usuario deletado com sucesso", "success");
           $scope.limpaCampos();
           $scope.buscaUsuarios();
       }
    }
})

