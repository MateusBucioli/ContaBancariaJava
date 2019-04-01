package br.com.db1.contaBancaria;

public class Cliente {

	private String nome;
	
	private  String cpf;
	
	public Cliente(String nome, String cpf) {	
		if (nome == null) {
			throw new RuntimeException("Nome é obrigatório");
		}
		
		if (nome.length() < 5) {
			throw new RuntimeException("Nome deve ser maior ou igual a 5");
		}
		
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
}
