package br.com.fiap.infra;

import br.com.fiap.biblioteca.dominio.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivroDAO {

    private Connection conexao;

    public LivroDAO(){
        this.conexao = new ConnectionFactory().getConnection();
    }



    public void adicionaLivro(Livro livro){
        String sql = "INSERT INTO a_tb_livro (titulo, autor, preco) VALUES (?,?,?)";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setDouble(3, livro.getPreco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Livro> listarLivros(){
        String sqlSelect = "SELECT * FROM a_tb_livro";
        ArrayList<Livro> Livros = new ArrayList<>();
        try(PreparedStatement pstmt = conexao.prepareStatement(sqlSelect);
            ResultSet rs = pstmt.executeQuery()){
            while (rs.next()){
                Livro livro = new Livro();
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setPreco(rs.getDouble("preco"));
                Livros.add(livro);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Livros;


    }

    public void fecharConexao(){
        try{
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
