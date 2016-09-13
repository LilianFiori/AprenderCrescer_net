/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.controller;

import br.com.senai.aprendercrescer.model.Usuario;
import br.com.senai.aprendercrescer.ws.UsuarioWs;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Senai
 */
public class UsuarioController {

    UsuarioWs UsuarioWs;

    public UsuarioController() {
        UsuarioWs = new UsuarioWs();
    }

    public boolean gravaUsuario(Usuario usuario) {
        if (usuario.getIdUsuario() != 0) {
            return UsuarioWs.updateUsuario(usuario);
        } else if (usuario.getValor) {
            JOptionPane.showMessageDialog(null, "Gasto de mais \nlancamento abortado");
            return false;
        } else {
            return UsuarioWs.insereUsuario(usuario);
        }

    }

    public ArrayList<Usuario> getAllUsuario() {

        return UsuarioWs.getAllUsuario();
    }

    public boolean excluirDado(int id) {

        return UsuarioWs.excluir(id);
    }

}

