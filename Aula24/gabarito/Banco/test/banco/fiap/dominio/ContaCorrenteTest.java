package banco.fiap.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaCorrenteTest {

	@Test
	void verificarIgualdade() {
		int banco = 555;
		String agencia = "666";
		String numero = "5454-4";
		String numero2 = "5454-4";
		
		ContaCorrente umaConta = new ContaCorrente(banco, agencia, numero, 4353);
		ContaCorrente outraConta = new ContaCorrente(banco, agencia, numero2, 34897);
		
		assertEquals(umaConta, outraConta);

		//assertFalse(umaConta.equals(outraConta));
	}
}
