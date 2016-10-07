/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.UsuarioController;
import br.com.senai.aprendercrescer.model.Usuario;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/usuario")
public class UsuarioWs {

    @GET
    @Path("/getusuario")
    @Produces("application/json")

    public Response getUsuario() {
        try {

            JSONObject retorno = new JSONObject();
            retorno.put("nome", "Lilian Fiori");
            retorno.put("idade", 16);
            return Response.status(200).entity(retorno.toString()).build();
        } catch (JSONException ex) {
            //logger.getLoger(UsuarioWs.class.getName()).log(Leve)
        }
        return Response.status(500).build();
    }

    @GET
    @Path("/getusuarios")
    @Produces("application/json")
    public Response getAllUsuarios() {
        // ArrayList<JSONObject> listaJson = new ArrayList<JSONObject>();

        try {
            UsuarioController ususarioControler;
            ususarioControler = new UsuarioController();
            ArrayList<Usuario> lista = ususarioControler.getUsuario();
            JSONObject jUsuario;
            StringBuilder retorno = new StringBuilder();
            retorno.append("[");
            boolean controle = false;
            for (Usuario usuario : lista) {
                if (controle) {
                    retorno.append(" , ");
                }

                jUsuario = new JSONObject();
                jUsuario.put("idUsuario", usuario.getIdUsuario());
                jUsuario.put("idGrupo", usuario.getIdGrupo());
                jUsuario.put("login", usuario.getLogin());
                jUsuario.put("senha", usuario.getSenha());
                jUsuario.put("nome", usuario.getNome());
                jUsuario.put("flagInativo", usuario.getFlagInativo() + "");
                retorno.append(jUsuario.toString());
                controle = true;
            }

            retorno.append("]");
            return Response.status(200).entity(retorno.toString()).build();
        } catch (Exception ex) {
            System.out.println("Erro:" + ex);
            return Response.status(200).entity(
                    "{erro : \"" + ex + "\"}").build();

        }
    }

    @POST
    @Path("/setusuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response setUsuario(InputStream dadosServ) {
        StringBuilder requisicaoFinal = new StringBuilder();
        String batata = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(dadosServ));
            String requisicao = null;
            while ((requisicao = in.readLine()) != null) {
                requisicaoFinal.append(requisicao);

            }
            System.out.println(requisicaoFinal.toString());

            JSONObject resposta = new JSONObject(requisicaoFinal.toString());
            Usuario usuario = new Usuario();

            usuario.setLogin(resposta.getString("login"));
            usuario.setNome(resposta.getString("nome"));
            usuario.setSenha(resposta.getString("senha"));
            usuario.setIdGrupo(resposta.getInt("idGrupo"));
            usuario.setFlagInativo(resposta.getString("flagInativo").toCharArray()[0]);
            usuario.setDtAlteracao(new Date());

            if (new UsuarioController().insereUsuario(usuario)) {
                return Response.status(200).entity("{\"result\" : \"Cadastrado\"}").build();
            } else {
                return Response.status(501).entity("{\"result\" : \" Erro no Cadastro\"}").build();
            }

        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();

        }
    }
    
    @POST
    @Path("/updateusuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response updateUsuario(InputStream dadosServ) {
        StringBuilder requisicaoFinal = new StringBuilder();
        String batata = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(dadosServ));
            String requisicao = null;
            while ((requisicao = in.readLine()) != null) {
                requisicaoFinal.append(requisicao);

            }
            System.out.println(requisicaoFinal.toString());

            JSONObject resposta = new JSONObject(requisicaoFinal.toString());
            Usuario usuario = new Usuario();

            usuario.setIdUsuario(resposta.getInt("idUsuario"));
            usuario.setLogin(resposta.getString("login"));
            usuario.setNome(resposta.getString("nome"));
            usuario.setSenha(resposta.getString("senha"));
            usuario.setIdGrupo(resposta.getInt("idGrupo"));
            usuario.setFlagInativo(resposta.getString("flagInativo").toCharArray()[0]);
            usuario.setDtAlteracao(new Date());

            if (new UsuarioController().insereUsuario(usuario)) {
                return Response.status(200).entity("{\"result\" : \"Cadastrado\"}").build();
            } else {
                return Response.status(501).entity("{\"result\" : \" Erro no Cadastro\"}").build();
            }

        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();
        }

        }
       
        
        @DELETE
        @Path ("/deleteusuario/{idusuario}")
        
        public Response deleteUsuario (@PathParam("idusuario") int idUsuario) {
        
        try{
           if(new UsuarioController().deleteUsuario(idUsuario)){
               Response.status(200).build();
           }else{
               Response.status(400).build();
           }
        }catch(Exception ex ) {
            return Response.status(400).entity(ex.toString()).build();
        }
        
        return Response.status(200).build();
    }
        
    }
    
    
    


