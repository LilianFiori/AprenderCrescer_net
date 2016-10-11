/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.model;

import java.util.Date;

/**
 *
 * @author Senai
 */
public class Usuario {

    private int idUsuario;
    private int idGrupo;
    private String login;
    private String senha;
    private String nome;
    private char flagInativo;
    private Date dtAlteracao;

    public void setIdusuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setidGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenhausuario(String senha) {
        this.senha = senha;
    }

    public void setNomeusuario(String nome) {
        this.nome = nome;
    }

    public void setFlaginativo(char flagInativo) {
        this.flagInativo = flagInativo;
    }

    public void setDtalteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public int getIdusuario() {
        return idUsuario;
    }

    public int getidGrupo() {
        return idGrupo;
    }

    public String getLogin() {
        return login;
    }

    public String getSenhausuario() {
        return senha;
    }

    public String getNomeusuario() {
        return nome;
    }

    public char getFlaginativo() {
        return flagInativo;
    }

    public Date getDtalteracao() {
        return dtAlteracao;
    }
    
    
}
