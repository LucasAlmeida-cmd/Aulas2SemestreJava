package infra;

import br.com.fiap.biblioteca.dominio.Livro;
import br.com.fiap.infra.LivroDAO;
import org.junit.jupiter.api.Test;

public class LivroDAOTest {

    @Test
    public void testAdicionarLivro() {
        LivroDAO livroDAO = new LivroDAO();
        Livro livro = new Livro("teste", "testr",100);
        livroDAO.adicionaLivro(livro);
    }
}
