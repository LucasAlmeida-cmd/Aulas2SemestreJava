package br.com.fiap.biblioteca.service;

import br.com.fiap.biblioteca.dominio.*;

public class AlunoService {

	private Mensageiro mensageiro;
	private Correios correios;
	private RepositorioAlunos repositorioAlunos;

	public AlunoService(Mensageiro mensageiro, Correios correios, RepositorioAlunos repositorioAlunos){
		this.mensageiro = mensageiro;
		this.correios = correios;
		this.repositorioAlunos = repositorioAlunos;
	}
	
	public void adicionar(Aluno aluno) {
		Endereco endereco = correios.obterEndereco(aluno.obterCep());
		aluno.atualizarEndereco(endereco);
		mensageiro.enviarMensagemA(aluno);
		repositorioAlunos.adicionar(aluno);
		repositorioAlunos.fechar();
	}
}
