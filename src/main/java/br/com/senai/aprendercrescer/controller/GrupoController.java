/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.controller;

import br.com.senai.aprendercrescer.dao.GrupoDao;
import br.com.senai.aprendercrescer.model.grupo;
import java.util.ArrayList;

/**
 *
 * @author Senai
 */
public class GrupoController {
    GrupoDao GrupoDao;

    public GrupoController() {
        
        if (GrupoDao == null) {
            GrupoDao = new GrupoDao();
        }
    }

    public boolean insereGrupo(grupo grupo) {
        return GrupoDao.insereGrupo(grupo);
    }

    public ArrayList<grupo> getGrupo() {
        return GrupoDao.getGrupo();
    }

    public boolean deleteUsuario(int id) {
        return GrupoDao.excluir(id);
        
    }
}


