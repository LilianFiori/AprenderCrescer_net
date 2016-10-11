/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.dao;

import br.com.senai.aprendercrescer.model.Conta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Senai
 */
public class ContaDao {
    
    Statement st;
    PreparedStatement prepst;

    static String INSERT = "INSERT INTO Conta("
            + " idconta, descricao, tipoconta, valor)"
            + "  VALUES ((SELECT COALESCE(max(idconta)+1,1) from conta) , ?, ?, ?, ?);";

    static String SELECTALL = "SELECT idconta, descricao, tipoconta, valor  FROM conta order by idconta";
    static String UPDATE = "UPDATE conta SET idconta=?, descricao=?, tipoconta=?,valor=?  WHERE idconta = ? ;";
    static String DELETE = "DELETE FROM conta  WHERE idconta = ?;";

    public boolean insereConta(Conta conta) {
        ResultSet rs;
        int id = 0;
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(INSERT);
            //preparedStatement.setInt(1, 0);
            preparedStatement.setInt(1, conta.getIdConta());
            preparedStatement.setString(2, conta.getDescricao() + "");
            preparedStatement.setString(3, conta.getTipoConta() + "");
            preparedStatement.setDouble(4, conta.getValor());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir conta: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public ArrayList<Conta> getConta() {
        ArrayList<Conta> lista = new ArrayList<Conta>();

        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(SELECTALL);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setIdConta(rs.getInt("idconta"));
                conta.setDescricao(rs.getString("descricao"));
                conta.setTipoConta(rs.getString("tipoconta"));
                conta.setValor(rs.getDouble("valor"));
                lista.add(conta);

            }

        } catch (Exception ex) {
            System.out.println("Problema ao carregar conta : " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return lista;
    }

    public boolean updateConta(Conta conta) {
        try {

            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(UPDATE);
            preparedStatement.setInt(1, conta.getIdConta());
            preparedStatement.setString(2, conta.getDescricao()+"");
            preparedStatement.setString(3, conta.getTipoConta()+"");  
            preparedStatement.setDouble(3, conta.getValor()); 
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao fazer update da conta: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }

        return false;
    }

    public boolean excluir(int id) {
        try {

            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao deletar a conta: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }

        return false;

    }

    
}
