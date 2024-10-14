package br.com.fiap.biblioteca.infra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.biblioteca.dominio.Aluno;

public class AlunoDAO {

	private Connection conexao;
	
	public AlunoDAO() {
		conexao = new ConnectionFactory().getConnection();
	}
	
	public void adicionar(Aluno aluno) {
		try {
			String sql = "INSERT INTO a_alunos (nome, chamada, turma) VALUES(?, ?, ?)";
			PreparedStatement comandoDeInsercao = conexao.prepareStatement(sql);
			comandoDeInsercao.setString(1, aluno.getNome());
			comandoDeInsercao.setString(2, aluno.getChamada());
			comandoDeInsercao.setString(3, aluno.getTurma());
			comandoDeInsercao.execute();
			comandoDeInsercao.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Aluno buscarAlunosPorTurmaEChamada(String turma, String chamada) {
		Aluno aluno = null;
		try {
			String sql = "SELECT * FROM ALUNOS WHERE TURMA = ? AND CHAMADA = ?";
			PreparedStatement comandoDeSelecao = conexao.prepareStatement(sql);
			comandoDeSelecao.setString(1, turma);
			comandoDeSelecao.setString(2, chamada);
			ResultSet resultados = comandoDeSelecao.executeQuery();
			while(resultados.next()) {
				aluno = new Aluno(resultados.getString("nome"),
						resultados.getString("chamada"),
						resultados.getString("turma"));
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return aluno;
	}

	public ArrayList<Aluno> buscarAlunosPorTurma(String turma){
		ArrayList<Aluno> alunos = new ArrayList<>();
		try {
			String sql = "SELECT * FROM ALUNOS WHERE TURMA = ?";
			PreparedStatement comandoDeSelecao = conexao.prepareStatement(sql);
			comandoDeSelecao.setString(1, turma);
			ResultSet resultados = comandoDeSelecao.executeQuery();
			while(resultados.next()) {
				Aluno aluno = new Aluno(resultados.getString("nome"),
						resultados.getString("chamada"),
						resultados.getString("turma"));
				alunos.add(aluno);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return alunos;
	}
	
	public void fechar() {
		try {
			conexao.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
