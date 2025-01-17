package banco.fiap;

import java.util.ArrayList;

import banco.fiap.dominio.ContaCorrente;
import banco.fiap.dominio.Correntista;

public class Banco {

	public static void main(String[] args) {
		int banco = 444;
		String agencia = "1095";
		
		ContaCorrente umaConta = new ContaCorrente(banco, agencia, "555-5", 1000);
		ContaCorrente outraConta = new ContaCorrente(banco, agencia, "666-7", 2000);
		
		try {
			umaConta.saque(10000);
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		outraConta.deposito(200);
		
		umaConta.saldo();
		
		System.out.println("Saldo de umaConta: " + umaConta.saldo());
		System.out.println("Saldo de outraConta: " + outraConta.saldo());
		
		ArrayList<ContaCorrente> contasCorrente = new ArrayList<>();
		contasCorrente.add(umaConta);
		contasCorrente.add(outraConta);
		
		Correntista correntistaJose = new Correntista("Jose", "65465587899", "6545675434567890", contasCorrente);
		correntistaJose.getCartaoDeCredito();
		
		correntistaJose.exibirTodosOsSaldos();
		
		
	}

}

//