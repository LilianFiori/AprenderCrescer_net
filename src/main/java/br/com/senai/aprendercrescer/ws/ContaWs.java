/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.ContaController;
import br.com.senai.aprendercrescer.model.Conta;
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
@Path("/contas")
public class ContaWs {
        @GET
        @Path("/getconta")
        @Produces("application/json")

        public Response getConta() {
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
        @Path("/getcontas")
        @Produces("application/json")

        public Response getAllConta() {
            try {
                ContaController ContaController;
                ContaController = new ContaController();
                ArrayList<Conta> lista = ContaController.getConta();
                JSONObject retorno = new JSONObject();
                JSONObject jContas;

                for (Conta conta : lista) {
                    jContas = new JSONObject();
                    jContas.put("idconta", conta.getIdConta());
                    jContas.put("descricao", conta.getDescricao());
                    jContas.put("valor", conta.getValor());
                    retorno.put("tipoconta" + conta.getTipoConta(), jContas);
                }
                return Response.status(200).entity(retorno.toString()).build();
            } catch (Exception ex) {
                System.out.println("Erro:" + ex);

                return Response.status(200).entity(
                        "{erro : \"" + ex + "\"}").build();
            }
        }

    }

