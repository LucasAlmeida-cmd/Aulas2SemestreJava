package br.com.fiap.biblioteca.dominio;

import java.util.ArrayList;

public interface RepositorioAlunos {

    void adicionar(Aluno aluno);
    ArrayList<Aluno> buscarAlunosPorTurma(String turma);
    Aluno buscarAlunosPorTurmaEChamada(String turma, String chamada);
    void fechar();
}
