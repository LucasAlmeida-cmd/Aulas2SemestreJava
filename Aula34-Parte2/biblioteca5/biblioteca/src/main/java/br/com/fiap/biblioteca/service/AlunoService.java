package br.com.fiap.biblioteca.service;

import br.com.fiap.biblioteca.dominio.Aluno;
import br.com.fiap.biblioteca.dominio.Correios;
import br.com.fiap.biblioteca.dominio.Mensageiro;

public class AlunoService {

	private Mensageiro mensageiro;
	private Correios correios;
	
	public void adicionar(Aluno aluno) {
		correios.obterEndereco(aluno.obterCep());
		mensageiro.enviarMensagemA(aluno);
	}
}
