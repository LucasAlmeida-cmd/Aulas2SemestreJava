package br.com.fiap.biblioteca.infra.dao;

import br.com.fiap.biblioteca.dominio.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDAO {
    private Connection conexao;

    public AlunoDAO(){
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void adiciona(Aluno aluno){
        String sqlInsert = "INSERT INTO a_alunos(nome, chamada, turma) VALUES(?, ?, ?)";
        try(PreparedStatement comandoDeInsercao = conexao.prepareStatement(sqlInsert);){
            comandoDeInsercao.setString(1, aluno.getNome());
            comandoDeInsercao.setString(2, aluno.getTurma());
            comandoDeInsercao.setString(3, aluno.getChamada());
            comandoDeInsercao.executeUpdate();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Aluno> listarTodosPorTurma(String turma){
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sqlSelect = "SELECT * FROM a_alunos where turma = ?";

        try(PreparedStatement comandoDeselecao = conexao.prepareStatement(sqlSelect)){
            comandoDeselecao.setString(1, turma);

            try(ResultSet rs = comandoDeselecao.executeQuery()){
                while(rs.next()){
                    Aluno aluno = new Aluno();
                    aluno.setNome(rs.getString("nome"));
                    aluno.setChamada(rs.getString("chamada"));
                    aluno.setTurma(rs.getString("turma"));
                    alunos.add(aluno);
                }
            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        return alunos;
    }


    public ArrayList<Aluno> listarPorTurmaEChamada(String turma, String chamada) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sqlSelect = "SELECT * FROM a_alunos WHERE turma = ? AND chamada = ?";

        try (PreparedStatement comandoDeselecao = conexao.prepareStatement(sqlSelect)) {
            // Passando os valores dos parâmetros da query
            comandoDeselecao.setString(1, turma);
            comandoDeselecao.setString(2, chamada);

            try (ResultSet rs = comandoDeselecao.executeQuery()) {
                while (rs.next()) {
                    Aluno aluno = new Aluno();
                    aluno.setNome(rs.getString("nome"));
                    aluno.setChamada(rs.getString("chamada"));
                    aluno.setTurma(rs.getString("turma"));
                    alunos.add(aluno);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return alunos;
    }



    public void fechar(){
        try{
            conexao.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}