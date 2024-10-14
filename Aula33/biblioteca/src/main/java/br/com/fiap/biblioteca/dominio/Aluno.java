package br.com.fiap.biblioteca.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Aluno {

    @JsonProperty
    private String nome;
    @JsonProperty
    private String chamada;
    @JsonProperty
    private String turma;

    public Aluno(String nome, String chamada, String turma) {
        this.nome = nome;
        this.chamada = chamada;
        this.turma = turma;
    }

    public Aluno(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChamada() {
        return chamada;
    }

    public void setChamada(String chamada) {
        this.chamada = chamada;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    // completar essa classe com os construtores e métodos necessários
}
