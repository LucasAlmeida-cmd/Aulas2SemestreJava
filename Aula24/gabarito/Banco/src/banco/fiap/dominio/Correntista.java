package banco.fiap.dominio;

import java.util.ArrayList;

public class Correntista {
	
	private String nome;
	private String cpf;
	private String cartaoDeCredito;
	private ArrayList<ContaCorrente> contasCorrente;

	public Correntista(String nome, String cpf, String cartaoDeCredito, ArrayList<ContaCorrente> contasCorrente){
		this.nome = nome;
		this.cpf = cpf;
		this.cartaoDeCredito = cartaoDeCredito;
		this.contasCorrente = contasCorrente;
	}
	
	public String getCartaoDeCredito() {
		return cartaoDeCredito;
	}
	
	public void exibirTodosOsSaldos() {
		for(ContaCorrente cc : contasCorrente) {
			System.out.println(cc.saldo());
		}
	}
}
