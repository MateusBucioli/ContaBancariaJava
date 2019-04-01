package br.com.db1.contaBancaria;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContaBancariaTeste {
	private ContaBancaria contaAlvo;
	private ContaBancaria conta;
	
	@Before // faz com que esse metodo seja executado antes dos demais metodos. 
	public void init() {
		Cliente cliente = new Cliente("Rodrigo", "99999999999");
		conta = new ContaBancaria("1234", "0004", 1000.0, ContaBancariaTipo.CORRENTE, cliente);
	}
	
	@Test
	public void deveSacarDinheiroDaConta() {
		conta.sacar(500.0);
		Assert.assertEquals(500.0, conta.getSaldo(), 0);
		Assert.assertEquals(1, conta.getHistoricos().size());
	}

	@Test (expected = RuntimeException.class)
	public void deveRetornarErroQuandoSaldoMenorQueSaque() {
		conta.sacar(2000.0);
	}
	
	@Test 
	public void deveDepositarDinheiroNaConta() {
		conta.depositar(500.0);
		Assert.assertEquals(1500.0, conta.getSaldo(),0);
		Assert.assertEquals(1, conta.getHistoricos().size());
	}
	
	@Test (expected = RuntimeException.class)
	public void deveRetornarErroCasoDepositoSejaNegativo() {
		conta.depositar(-500.0);
	}
	@Test (expected = RuntimeException.class)
	public void deveRetornarErroCasoDepositoSejaZero() {
		conta.depositar(0.0);
	}
	@Test
	public void deveTransferirValorDeUmaContaParaOutra() {
		conta.transferir(500.0, contaAlvo);
		Assert.assertEquals(500.0, conta.getSaldo(), 0);
		Assert.assertEquals(1500.0, contaAlvo.getSaldo(), 0);
	}
}
 