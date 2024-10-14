package br.com.fiap.biblioteca.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CorreiosTest {

	@Test
	void buscarEndereco() {
		Correios c = new Correios();
		Endereco e = c.obterEndereco("01001000");

		assertEquals("01001-000", e.getCep());
		assertEquals("Praça da Sé", e.getLogradouro());
		assertEquals("lado ímpar", e.getComplemento());
		assertEquals("Sé", e.getBairro());
		assertEquals("São Paulo", e.getLocalidade());
		assertEquals("SP", e.getUf());
	}
}
