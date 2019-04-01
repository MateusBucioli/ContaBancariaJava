package br.com.db1.contaBancaria;

import java.util.ArrayList;
import java.util.List;

import br.com.db1.contaBancaria.ContaBancariaTipo;
 
public class ContaBancaria {
	private String numero;
	private String agencia;
	private Double saldo; 
	private ContaBancariaTipo tipo = ContaBancariaTipo.CORRENTE;
	private List<ContaBancariaHistorico> historicos = new ArrayList<>();
	private Cliente cliente;

	public ContaBancaria(String numero, String agencia, Double saldo, ContaBancariaTipo tipo, Cliente cliente) {
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
		this.tipo = tipo;
		this.cliente = cliente;
	}
 
	// realiza saque
	public void sacar(Double valor) {
		if(valor>saldo) {
			throw new RuntimeException("Saldo insuficiente: "+saldo);
		}
		this.saldo = this.saldo - valor;
		atualizaHistorico(ContaBancariaTipoOperacao.SAIDA, valor);
	}

	// realiza deposito
	public void depositar(Double valor) {
		if(valor<=0) {
			throw new RuntimeException("Operação invalida");
		}
		this.saldo = this.saldo + valor;
		atualizaHistorico(ContaBancariaTipoOperacao.ENTRADA, valor);
	}
	
	// realiza transferencia
	public void transferir(Double valor, ContaBancaria contaAlvo) {
		if (valor <= 0) {
			throw new RuntimeException("Valor de transferencia invalido");
		}
		if (contaAlvo == null) {
			throw new RuntimeException("Conta do destinatário é obrigatória");
		}
		this.sacar(valor); 
		contaAlvo.depositar(valor);
	}
	
	// atualiza o historico de operacoes
	public void atualizaHistorico(ContaBancariaTipoOperacao tipo, Double valor) {
		ContaBancariaHistorico historico = new ContaBancariaHistorico(tipo, valor);
		this.historicos.add(historico);
	}
	
	//retorna o saldo
	public Double getSaldo() {
		return this.saldo;
	}
	
	// retorna o historico
	public List<ContaBancariaHistorico> getHistoricos(){
		return this.historicos;
	}
	
}
