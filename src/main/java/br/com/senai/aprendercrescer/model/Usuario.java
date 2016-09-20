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
    private int senha;
    private String nome;
    private char flagInativo;
    private Date dtAlteracao;

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFlagInativo(char flagInativo) {
        this.flagInativo = flagInativo;
    }

    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public String getLogin() {
        return login;
    }

    public int getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public char getFlagInativo() {
        return flagInativo;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }
    
    
}
