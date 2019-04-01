package br.com.db1.contaBancaria;

public class App {
	public static void main(String[] args) {
		Cliente cliente = new Cliente("Mateus", "99999999999");
		
		ContaBancaria conta = new ContaBancaria("1234", "0004", 1000.0, ContaBancariaTipo.CORRENTE, cliente);
		
	}
}
