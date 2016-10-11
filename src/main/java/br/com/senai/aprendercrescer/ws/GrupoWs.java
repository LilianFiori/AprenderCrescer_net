/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.GrupoController;
import br.com.senai.aprendercrescer.model.Grupo;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Senai
 */
@Path("/grupo")
public class GrupoWs {

    @GET
    @Path("/getgrupo")
    @Produces("application/json")

    public Response getGrupo() {
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
    @Path("/getgrupos")
    @Produces("application/json")

    public Response getAllGrupo() {
        try {
            GrupoController grupoController;
            grupoController = new GrupoController();
            ArrayList<Grupo> lista = grupoController.getGrupo();
            JSONObject jGrupo;
            
            StringBuilder retorno = new StringBuilder();
            retorno.append("[");
            boolean controle = false;
            for (Grupo grupo : lista) {
                if (controle) {
                    retorno.append(" , ");
                }

                jGrupo = new JSONObject();
                jGrupo.put("idGrupo", grupo.getIdgrupo());
                jGrupo.put("TipoUsuario", grupo.getTipousuario());
                jGrupo.put("DescricaoGrupo" , grupo.getDescricaogrupo());
                retorno.append(jGrupo.toString());
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
    @Path("/setgrupo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response setGrupo(InputStream dadosServ) {
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
            Grupo grupo = new Grupo();

            grupo.setTipousuario(resposta.getString("tipousuario"));
            grupo.setDescricaogrupo(resposta.getString("descricaogrupo"));

            new GrupoController().insereGrupo(grupo);
            Response.status(200).entity(requisicaoFinal.toString()).build();

        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();

        }
        return null;

    }

}
