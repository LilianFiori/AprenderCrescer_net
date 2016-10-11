/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.controller;

import br.com.senai.aprendercrescer.dao.UsuarioDao;
import br.com.senai.aprendercrescer.model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Senai
 */
public class UsuarioController {

    UsuarioDao usuarioDao;

    public UsuarioController() {
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDao();
        }
    }

    public boolean insereUsuario(Usuario usuario) throws SQLException {
        usuarioDao.gravar(usuario);
        return true;
    }

    public ArrayList<Usuario> getUsuario() {
        return usuarioDao.getAll();
    }

    public boolean deleteUsuario(int id) {
       Usuario us = new Usuario(id);
       usuarioDao.apagar(us);
        return true;
    }
}
