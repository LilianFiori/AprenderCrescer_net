/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.dao;

import br.com.senai.aprendercrescer.model.grupo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Senai
 */
public class GrupoDao {
    
    Statement st;
    PreparedStatement prepst;

    static String INSERT = "INSERT INTO grupo("
            + " idgrupo, tipousuario, descricaogrupo)"
            + "  VALUES ((SELECT COALESCE(max(idgrupo)+1,1) from grupo) , ?, ?);";

    static String SELECTALL = "SELECT idgrupo, tipousuario, descricaogrupo  FROM grupo order by idgrupo";
    static String UPDATE = "UPDATE grupo SET idgrupo=?, tipousuario=?, descricaogrupo=?  WHERE idgrupo = ? ;";
    static String DELETE = "DELETE FROM grupo  WHERE idgrupo = ?;";

    public boolean insereGrupo(grupo grupoDao) {
        ResultSet rs;
        int id = 0;
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(INSERT);
            //preparedStatement.setInt(1, 0);
            preparedStatement.setInt(1, grupoDao.getIdGrupo());
            preparedStatement.setString(2, grupoDao.getTipoUsuario() + "");
            preparedStatement.setString(2, grupoDao.getDescricaoGrupo() + "");
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir grupo: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return false;
    }

    public ArrayList<grupo> getGrupo() {
        ArrayList<grupo> lista = new ArrayList<grupo>();

        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(SELECTALL);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                grupo conta = new grupo();
                conta.setTipoUsuario(rs.getString("tipousuario"));
                conta.setDescricaoGrupo(rs.getString("descricaogrupo"));
                lista.add(conta);

            }

        } catch (Exception ex) {
            System.out.println("Problema ao carregar grupo : " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return lista;
    }

    public boolean updateGrupo(grupo grupo) {
        try {

            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(UPDATE);
            preparedStatement.setInt(1, grupo.getIdGrupo()); 
            preparedStatement.setString(2, grupo.getTipoUsuario()+"");  
            preparedStatement.setString(3, grupo.getDescricaoGrupo()+"");     
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao fazer update do grupo: " + ex);
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
            System.out.println("Problema ao deletar o grupo: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }

        return false;

    }

    
}
