/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.controller;

import br.com.senai.aprendercrescer.dao.ConexaoDao;
import br.com.senai.aprendercrescer.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Senai
 */
public class UsuarioController {

    ConexaoDao conexaoDao;

    public UsuarioController() {
        if (conexaoDao == null) {
            conexaoDao = new ConexaoDao();
        }
    }

    public boolean insereUsuario(Usuario usuario) {
        return conexaoDao.insereUsuario(usuario);
    }

    public ArrayList<Usuario> getUsuario() {
        return conexaoDao.getAllUsuario();
    }

    public boolean deleteUsuario(int id) {
        return conexaoDao.excluir(id);
        
    }
}
