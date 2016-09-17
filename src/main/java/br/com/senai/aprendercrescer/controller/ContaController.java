/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.controller;

import br.com.senai.aprendercrescer.dao.ContaDao;
import br.com.senai.aprendercrescer.model.Conta;
import java.util.ArrayList;

/**
 *
 * @author Senai
 */
public class ContaController {
    ContaDao ContaDao;

    public ContaController() {
        
       
        
        if (ContaDao == null) {
            ContaDao = new ContaDao();
        }
    }

    public boolean insereConta(Conta conta) {
        return ContaDao.insereConta(conta);
    }

    public ArrayList<Conta> getConta() {
        return ContaDao.getConta();
    }

    public boolean deleteConta(int id) {
        return ContaDao.excluir(id);
        
    }
    
}
