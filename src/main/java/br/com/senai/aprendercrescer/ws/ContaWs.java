/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.aprendercrescer.ws;

import br.com.senai.aprendercrescer.controller.ContaController;
import br.com.senai.aprendercrescer.model.Conta;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
@Path("/conta")
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
            JSONObject jContas;

            StringBuilder retorno = new StringBuilder();
            retorno.append("[");
            boolean controle = false;
            for (Conta conta : lista) {
                if (controle) {
                    retorno.append(" , ");
                }

                jContas = new JSONObject();
                jContas.put("idconta", conta.getIdconta());
                jContas.put("descricao", conta.getDescricao());
                jContas.put("tipoconta", conta.getTipoconta());
                jContas.put("valor", conta.getValor());
                retorno.append(jContas.toString());
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
    @Path("/setconta")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response setConta(InputStream dadosServ) {
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
            Conta conta = new Conta();

            conta.setDescricao(resposta.getString("descricao"));
            conta.setTipoconta(resposta.getString("tipoconta"));
            conta.setValor(resposta.getDouble("valor"));

            new ContaController().insereConta(conta);
            Response.status(200).entity(requisicaoFinal.toString()).build();

        } catch (Exception ex) {
            return Response.status(501).entity(ex.toString()).build();

        }
        return null;

    }

}
