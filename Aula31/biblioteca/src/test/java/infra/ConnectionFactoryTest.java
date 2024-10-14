package infra;

import br.com.fiap.infra.ConnectionFactory;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectionFactoryTest {

    @Test
    void conectaComSucesso() {
        try {
            Connection conexao = new ConnectionFactory().getConnection();
            conexao.close();
        }
        catch(Exception e) {
            fail("Conexão não foi criada com sucesso");
        }
    }
}
