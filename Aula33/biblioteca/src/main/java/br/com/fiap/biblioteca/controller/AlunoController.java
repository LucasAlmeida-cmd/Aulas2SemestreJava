package br.com.fiap.biblioteca.controller;

import br.com.fiap.biblioteca.dominio.Aluno;
import br.com.fiap.biblioteca.infra.dao.AlunoDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("alunos")
public class AlunoController {

    // complete essa classe com os métodos, atributos e anotações necessárias.
    private static final ArrayList<Aluno> listaAluno = new ArrayList<>();

    AlunoDAO alunoDAO = new AlunoDAO();


    @POST
    public Response adicionar(Aluno aluno){
        alunoDAO.adiciona(aluno);
        alunoDAO.fechar();
//        listaAluno.add(aluno);
        return Response.status(Response.Status.CREATED).build();
    }



    @Path("/{turma}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorTurma(@PathParam("turma") String turma) {
        ArrayList<Aluno> alunosTurma = alunoDAO.listarTodosPorTurma(turma);
        alunoDAO.fechar();
        return Response.status(Response.Status.OK).entity(alunosTurma).build();
    }


    @Path("/{turma}/{chamada}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorTurmaEChamada(@PathParam("turma") String turma, @PathParam("chamada") String chamada) {
        ArrayList<Aluno> alunosPorTurmaEChamada = alunoDAO.listarPorTurmaEChamada(turma, chamada);
        alunoDAO.fechar();
        return Response.status(Response.Status.OK).entity(alunosPorTurmaEChamada).build();
    }
}
