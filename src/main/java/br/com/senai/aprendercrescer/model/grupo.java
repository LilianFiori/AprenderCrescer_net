/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.model;

/**
 *
 * @author Senai
 */
public class grupo {
    private int idGrupo;
    private String TipoUsuario;
    private String DescricaoGrupo;

    public int getIdGrupo() {
        return idGrupo;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public String getDescricaoGrupo() {
        return DescricaoGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    public void setDescricaoGrupo(String DescricaoGrupo) {
        this.DescricaoGrupo = DescricaoGrupo;
    }
    
    
}
