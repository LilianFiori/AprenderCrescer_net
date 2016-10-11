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
public class Conta {
   
    private int IdConta;
    private String Descricao;
    private String TipoConta;
    private double Valor;

    public int getIdConta() {
        return IdConta;
    }

    public String getDescricao() {
        return Descricao;
    }

    public String getTipoConta() {
        return TipoConta;
    }

    public double getValor() {
        return Valor;
    }

    public void setIdConta(int IdConta) {
        this.IdConta = IdConta;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public void setTipoConta(String TipoConta) {
        this.TipoConta = TipoConta;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
    
    
    
}
