package br.com.fiap.biblioteca.controller;

import br.com.fiap.biblioteca.dominio.Livro;
import br.com.fiap.infra.LivroDAO;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("livros")
public class LivroController {

//    private static ArrayList<Livro> livros = new ArrayList<>();


//    public ArrayList<Livro> retornaLivros(){
//        return livros;
//    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaLivros(){
        LivroDAO livroDAO = new LivroDAO();

        ArrayList<Livro> livros = livroDAO.listarLivros();
        livroDAO.fecharConexao();

        return Response.status(Response.Status.OK).entity(livros).build();

    }

    @POST
    public Response salvarLivro(Livro livro){
        LivroDAO livroDAO = new LivroDAO();
        livroDAO.adicionaLivro(livro);
        livroDAO.fecharConexao();
        return Response.status(Response.Status.CREATED).build();
    }

}
