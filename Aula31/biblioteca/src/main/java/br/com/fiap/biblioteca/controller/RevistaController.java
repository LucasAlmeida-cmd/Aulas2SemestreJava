package br.com.fiap.biblioteca.controller;

import br.com.fiap.biblioteca.dominio.Revista;
import br.com.fiap.infra.RevistaDAO;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("revistas")
public class RevistaController {

//    private static ArrayList<Revista> revistas = new ArrayList<>();

    @POST
    public Response addRevista(Revista revista){
        RevistaDAO revistaDAO = new RevistaDAO();
        revistaDAO.adicionaRevista(revista);
        revistaDAO.fecharConexao();
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarRevista(){
        RevistaDAO revistaDAO = new RevistaDAO();
        ArrayList<Revista> revistas = revistaDAO.listandoRevistas();
        return Response.status(Response.Status.OK).entity(revistas).build();
    }


}
