/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.dao;

import br.com.senai.aprendercrescer.model.Usuario;
import java.sql.Date;
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
public class UsuarioDao {
    
    Statement st;
    PreparedStatement prepst;

    static String INSERT = "INSERT INTO public.usuario(idusuario, login, nomeusuario, senhausuario, idgrupo  "
            + " ,flaginativo ) "
            + " VALUES ((SELECT COALESCE(max(idusuario)+1,1) from usuario), ?, ?, ?, ?, ?);";

    static String SELECTALL = "SELECT  IDUSUARIO, IDGRUPO,LOGIN, SENHAUSUARIO, NOMEUSUARIO,DTALTERACAO,FLAGINATIVO FROM USUARIO";
    static String UPDATE = "UPDATE conta SET idconta=?, descricao=?, tipoconta=?, valor=?  WHERE idconta = ? ;";
    static String DELETE = "DELETE FROM conta  WHERE idconta = ?;";

    public boolean insereUsuario(Usuario usuario)throws SQLException{
        ResultSet rs;
        int id = 0;
        //try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(INSERT);
            //preparedStatement.setInt(1, 0);
            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getNome() + "");
            preparedStatement.setInt(3, usuario.getSenha());
            preparedStatement.setInt(4, usuario.getIdGrupo());
            preparedStatement.setString(5, usuario.getFlagInativo()+"");
           // preparedStatement.setString(6,  usuario.getDtAlteracao().toString());
            
            preparedStatement.execute();
            return true;
/*
        } catch (SQLException ex) {
            System.out.println("Problema ao inserir usuario: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }*/
        
    }

    public ArrayList<Usuario> getAllUsuario() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(SELECTALL);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Usuario conta = new Usuario();
                conta.setLogin(rs.getString("LOGIN"));
                conta.setNome(rs.getString("NOMEUSUARIO"));
                conta.setSenha(rs.getInt("SENHAUSUARIO"));
                conta.setIdGrupo(rs.getInt("IDGRUPO"));
                conta.setIdUsuario(rs.getInt("IDUSUARIO"));
                conta.setFlagInativo(rs.getString("FLAGINATIVO").toCharArray()[0]);
                conta.setDtAlteracao(rs.getDate("DTALTERACAO"));
                
                lista.add(conta);

            }

        } catch (Exception ex) {
            System.out.println("Problema ao carregar usuarios : " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }
        return lista;
    }

    public boolean updateUsuario(Usuario usuario) {
        try {

            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(UPDATE);
            preparedStatement.setInt(1, usuario.getIdGrupo());
            preparedStatement.setInt(2, usuario.getIdUsuario());
            preparedStatement.setString(3, usuario.getNome() + "");
            preparedStatement.setString(4, usuario.getLogin());
            preparedStatement.setInt(5, usuario.getSenha());
            preparedStatement.setString(6, usuario.getFlagInativo()+"");
            preparedStatement.setDate(7, (Date) usuario.getDtAlteracao());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problema ao fazer update do usuario: " + ex);
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
            System.out.println("Problema ao deletar o usuario: " + ex);
            JOptionPane.showMessageDialog(null, "Erro:" + ex);
        }

        return false;

    }

}

