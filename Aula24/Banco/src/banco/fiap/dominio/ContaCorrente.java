package banco.fiap.dominio;

public class ContaCorrente {

	private double saldo;
	
	public ContaCorrente(double saldo){
		this.saldo = saldo;
	}
	
	public void saque(double valor){
		if(valor > saldo) {
			throw new IllegalArgumentException("Valor do saque maior que o saldo atual. Saque não realizado");
		}
		else {
			saldo = saldo - valor;
		}
	}
	
	public void deposito(double valor) {
		if(valor <= 0) {
			throw new IllegalArgumentException("Valor do depósito deve ser maior que zero. Depósito não realizado");
		}
		saldo = saldo + valor;
	}
	
	public double saldo() {
		return saldo;
	}
}
