package br.com.fiap.infra;

import br.com.fiap.biblioteca.dominio.Revista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RevistaDAO {

    private Connection conexao;

    public RevistaDAO(){
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void adicionaRevista(Revista revista){
        String sql = "INSERT INTO a_tb_revista (nome, descricao, preco) VALUES (?,?,?)";
        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, revista.getNome());
            stmt.setString(2, revista.getDescricao());
            stmt.setDouble(3, revista.getPreco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Revista> listandoRevistas(){
        String sql = "SELECT * FROM a_tb_revista";
        ArrayList<Revista> revistas = new ArrayList<>();
        try(PreparedStatement psmt = conexao.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery()) {
            while (rs.next()){
                Revista revista = new Revista();
                revista.setId(rs.getLong("id_revista"));
                revista.setNome(rs.getString("nome"));
                revista.setDescricao(rs.getString("descricao"));
                revista.setPreco(rs.getDouble("preco"));
                revistas.add(revista);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return revistas;
    }

    public void fecharConexao(){
        try{
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
