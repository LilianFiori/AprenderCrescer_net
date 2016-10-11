/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.controller;

import br.com.senai.aprendercrescer.dao.GrupoDao;
import br.com.senai.aprendercrescer.model.Grupo;
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

    public boolean insereGrupo(Grupo grupo) {
        GrupoDao.gravar(grupo);
        return true;
    }

    public ArrayList<Grupo> getGrupo() {
        return GrupoDao.getAll();
    }

    public boolean deleteUsuario(int id) {
       Grupo grupo = new Grupo();
       grupo.setIdgrupo(id);
       GrupoDao.apagar(grupo);
        return true;
    }
}


