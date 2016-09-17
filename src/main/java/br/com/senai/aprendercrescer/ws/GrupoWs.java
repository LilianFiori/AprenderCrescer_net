/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.GrupoController;
import br.com.senai.aprendercrescer.model.grupo;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
            ArrayList<grupo> lista = grupoController.getGrupo();
            JSONObject retorno = new JSONObject();
            JSONObject jGrupo;

            for (grupo grupo : lista) {
                jGrupo = new JSONObject();
                jGrupo.put("idGrupo", grupo.getIdGrupo());
                jGrupo.put("TipoUsuario", grupo.getTipoUsuario());
                retorno.put("DescricaoGrupo" + grupo.getDescricaoGrupo(), jGrupo);
            }
            return Response.status(200).entity(retorno.toString()).build();
        } catch (Exception ex) {
            System.out.println("Erro:" + ex);

            return Response.status(200).entity(
                    "{erro : \"" + ex + "\"}").build();
        }
    }
}


