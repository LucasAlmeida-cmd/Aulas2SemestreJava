package infra;

import br.com.fiap.biblioteca.dominio.Revista;
import br.com.fiap.infra.RevistaDAO;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class RevistaDAOTest {

    @Test
    public void testAdicionandoRevista(){
        RevistaDAO revistaDAO = new RevistaDAO();
        Revista revista = new Revista("Revista2", "revista2", 20);
        revistaDAO.adicionaRevista(revista);
    }

    @Test
    public void listandoRevistas(){
        RevistaDAO revistaDAO = new RevistaDAO();
        ArrayList<Revista> revistas = revistaDAO.listandoRevistas();

        for (Revista f: revistas){
            System.out.println("Id: "+f.getId());
            System.out.println("Nome: "+f.getNome());
            System.out.println("Descrição: "+ f.getDescricao());
            System.out.println("Preço: "+f.getPreco());
            System.out.println("-------------");
        }
    }

}
